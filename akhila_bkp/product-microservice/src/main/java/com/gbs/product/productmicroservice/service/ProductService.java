package com.gbs.product.productmicroservice.service;

import java.util.List;
import java.util.Optional;

import com.gbs.product.productmicroservice.model.Product;

public interface ProductService {

    Product create(Product product);

    Optional<Product> findById(Integer id);

    List<Product> findAll();

    Product save(Product product);

    List<Product> getBycatg(String productCategory);

}
