package com.catalog.catalogservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.catalog.catalogservice.model.Catalog;
import com.catalog.catalogservice.repository.CatalogRepository;

@CrossOrigin(origins= "*")
@RestController
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @PostMapping(value = "/addCatalog")
    public void saveCatalog(@RequestBody Catalog catalog) {
     
        catalogRepository.save(catalog);

    }
    
    @GetMapping("/getCatalogs")
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @DeleteMapping("/deleteCatalog/{id}")
    public void deleteCatalog(@PathVariable Integer id) {
        catalogRepository.deleteById(id);

    }

    @GetMapping("/catalog/{id}")
    public Optional<Catalog> findCatalogById(@PathVariable Integer id) {
        return catalogRepository.findById(id);

    }

    @PutMapping("/catalog/{id}")
    public ResponseEntity<Catalog> updateCatalog(@RequestBody Catalog catalog,@PathVariable Integer id) {
        Catalog updatedCatalog = catalogRepository.findById(id)
                .orElseThrow();

                updatedCatalog.setCatalog_id(catalog.getCatalog_id());
                updatedCatalog.setBusinessLine(catalog.getBusinessLine());
                

        catalogRepository.save(updatedCatalog);

        return ResponseEntity.ok(updatedCatalog);
    }

}

