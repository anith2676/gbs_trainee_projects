package com.gbs.product.productmicroservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbs.product.productmicroservice.model.Product;
import com.gbs.product.productmicroservice.repository.ProductRepository;
import com.gbs.product.productmicroservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    // TODO: Add a new product to the database

    @GetMapping("/search")
    public HashMap<Object, Object> getByProd(@RequestParam String productCategory) {
        var response = new HashMap<Object, Object>();

      
            if (productCategory != null) {
                List<Product> product = new ArrayList<>();
                product = productService.getBycatg(productCategory);

                if (product.size() >= 1 && product != null) {
                    response.put("Search Results:", product );
                } else {
                    response.put("message", "no data found");
                }
            }
       
        return response;
    }

    @GetMapping({ "/", "" })
    public ResponseEntity<Map<Object, Object>> getAllItems() {
        var products = productService.findAll();
        var response = new HashMap<Object, Object>();
        if (products.isEmpty()) {
            response.put("message", "No Products found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }
        response.put("message", "Products found");
        response.put("products", products);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id).orElseThrow());
    }

    @PostMapping("/findProductsByIdList")
    public ResponseEntity<Map<Object, Object>> createItems(@RequestBody List<Integer> ids) {
        Map<Object, Object> response = new HashMap<>();
        
        List<Product> products =  (List<Product>) productRepository.findAllById(ids);
        if(products.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("status", HttpStatus.OK);
        response.put("products", products);
        
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

   

}
