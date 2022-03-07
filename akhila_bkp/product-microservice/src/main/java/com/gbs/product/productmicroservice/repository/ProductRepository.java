package com.gbs.product.productmicroservice.repository;

import java.util.List;

import com.gbs.product.productmicroservice.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("FROM Product p WHERE p.productCategory like %?1%")
    List<Product> getBycatg(String productCategory);

}
