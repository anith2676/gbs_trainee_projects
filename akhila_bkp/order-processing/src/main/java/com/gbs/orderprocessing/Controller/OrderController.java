package com.gbs.orderprocessing.Controller;

import com.gbs.orderprocessing.Model.Order;
import com.gbs.orderprocessing.Model.Product;

import java.util.HashMap;
import java.util.Map;

import com.gbs.orderprocessing.Model.Login;
import com.gbs.orderprocessing.Services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDto,
            @RequestHeader(name = "Authorization") String token) {

        Integer userId = Integer.parseInt(token.split(" ")[1].trim());
        System.err.println("userId: " + userId);

        // add a rest template call to signup service to find user by id
        // add a model class called user
        // add a one to one unidirectional realtionship from order -> user

        ProductDTO productDTO = restTemplate.postForObject(
                "http://localhost:9000/api/products/findProductsByIdList", orderDto.getProducts(),
                ProductDTO.class);

        SignUpDTO signUpDTO = restTemplate.getForObject("http://localhost:6000/api/signUp/findByUserId/{id}",
                SignUpDTO.class, userId);

        System.err.println("signup DTO" + signUpDTO);

        System.err.println("productDTO.getProducts()" + productDTO.getProducts());

        Order order = new Order();
        Login userPlacongOrder = new Login();
        userPlacongOrder.setId(signUpDTO.getUser().getId());
        userPlacongOrder.setEmployeeName(signUpDTO.getUser().getEmployeeName());
        userPlacongOrder.setContactNum(signUpDTO.getUser().getContactNum());
       
        order.setFeedback(orderDto.getFeedback());
       
        order.setProducts(productDTO.getProducts());
        order.setUser(userPlacongOrder);
       order.setOrderStatus("created");

        Double totalPrice = productDTO.getProducts().stream().mapToDouble(Product::getProductPrice).sum();
        order.setNetPrice(totalPrice);
        
        productDTO.getProducts().forEach(p -> p.setOrder(order));

        System.err.println("entity" + order);

        Order savedOrder = orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

     @PutMapping("/orderStatus/{id}")
     public ResponseEntity<Map<Object, Object>>  orderStatus(@PathVariable Integer id) {
        Map<Object, Object> response = new HashMap();

        Order order = orderService.getOrderById(id).orElseThrow();
        order.setOrderStatus("paid");
        orderService.save(order);
        response.put("status" ,HttpStatus.OK);
        response.put("order", order);
        return ResponseEntity.status(HttpStatus.OK).body(response);

     }

}
