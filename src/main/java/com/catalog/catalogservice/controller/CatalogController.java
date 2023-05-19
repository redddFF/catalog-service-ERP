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
import com.catalog.catalogservice.model.Product;
import com.catalog.catalogservice.repository.CatalogRepository;
import com.catalog.catalogservice.repository.ProductRepository;

@CrossOrigin(origins = "*")
@RestController
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;
@Autowired
private ProductRepository productRepository  ; 
    @PostMapping(value = "/api/addCatalog")
    public void saveCatalog(@RequestBody Catalog catalog) {
     
        catalogRepository.save(catalog);

    }

  
    @GetMapping("/api/getCatalogs")
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @DeleteMapping("/api/deleteCatalog/{id}")
    public void deleteCatalog(@PathVariable Integer id) {
       
        
        
        catalogRepository.deleteById(id);

    }

    @GetMapping("/api/catalog/{id}")
    public Optional<Catalog> findCatalogById(@PathVariable Integer id) {
        return catalogRepository.findById(id);

    }

    @PutMapping("/api/catalog/{id}")
    public ResponseEntity<Catalog> updateCatalog(@RequestBody Catalog catalog,@PathVariable Integer id) {
        Catalog updatedCatalog = catalogRepository.findById(id)
                .orElseThrow();

                
                updatedCatalog.setBusinessLine(catalog.getBusinessLine());
                updatedCatalog.setDescription(catalog.getDescription());

        catalogRepository.save(updatedCatalog);

        return ResponseEntity.ok(updatedCatalog);
    }

}

