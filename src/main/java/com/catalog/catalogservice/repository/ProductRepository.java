package com.catalog.catalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalog.catalogservice.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
  
}
