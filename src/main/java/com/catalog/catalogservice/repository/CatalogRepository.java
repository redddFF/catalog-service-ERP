package com.catalog.catalogservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.catalog.catalogservice.model.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog,Integer> {
    
}
