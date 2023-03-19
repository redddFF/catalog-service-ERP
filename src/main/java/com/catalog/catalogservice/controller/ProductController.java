package com.catalog.catalogservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.catalogservice.model.Product;
import com.catalog.catalogservice.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "/addProduct")
    public void saveProduct(@RequestBody Product product) {
        Product p = new Product(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getVersion(),
            product.getTestStatus(),
            product.getResources(),
            product.getTechnologies(), null
        );
        productRepository.save(p);

    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);

    }

    @GetMapping("/product/{id}")
    public Optional<Product> findProductById(@PathVariable Integer id) {
        return productRepository.findById(id);

    }

}
