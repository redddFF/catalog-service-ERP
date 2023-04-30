package com.catalog.catalogservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.catalog.catalogservice.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Integer>{
    
}
