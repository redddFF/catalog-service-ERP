package com.catalog.catalogservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.catalog.catalogservice.model.Technology;


public interface TechnologyRepository extends JpaRepository<Technology,Integer>{
    
}
