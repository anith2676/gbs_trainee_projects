package com.gbs.product.productmicroservice.service;

import java.util.List;
import java.util.Optional;

import com.gbs.product.productmicroservice.model.Product;
import com.gbs.product.productmicroservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {

        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> getBycatg(String productCategory) {

        return productRepository.getBycatg(productCategory);
    }

   
}
