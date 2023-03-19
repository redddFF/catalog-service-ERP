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
import com.catalog.catalogservice.model.Catalog;
import com.catalog.catalogservice.repository.CatalogRepository;
@RestController
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @PostMapping(value = "/addCatalog")
    public void saveCatalog(@RequestBody Catalog catalog) {
        Catalog cg = new Catalog(
                catalog.getId(),
                catalog.getProduct(),
                catalog.getBusinessLine());
        catalogRepository.save(cg);

    }


    @GetMapping("/getCatalogs")
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @DeleteMapping("/deleteCatalog/{id}")
    public void deleteCatalog(@PathVariable Integer id){
     catalogRepository.deleteById(id);

       
    }

    @GetMapping("/Catalog/{id}")
    public Optional<Catalog> findCatalogById(@PathVariable Integer id){
       return  catalogRepository.findById(id) ;
       
        
    }

}
