package com.catalog.catalogservice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;

import java.util.Optional;
import java.util.Set;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catalog.catalogservice.model.Catalog;
import com.catalog.catalogservice.model.Product;
import com.catalog.catalogservice.model.Resource;
import com.catalog.catalogservice.model.Technology;
import com.catalog.catalogservice.repository.CatalogRepository;
import com.catalog.catalogservice.repository.ProductRepository;
import com.catalog.catalogservice.repository.ResourceRepository;
import com.catalog.catalogservice.repository.TechnologyRepository;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private ResourceRepository resourceRepository;
  
    @PostMapping(value = "/api/catalogs/{catalog_id}/addProduct")
    public void saveProduct(@PathVariable("catalog_id") Integer id , @RequestBody Product product) {

if (product.getFileName()!=null && product.getData()!=null ){
        String fileName = product.getFileName();
        String base64String = product.getData();
        byte[] bytes = Base64.getDecoder().decode(base64String);
        Path path = Paths.get("src/main/resources/public/files/" + fileName);
     try {
        Files.write(path, bytes);
        product.setImagePath("http://localhost:8081/files/"+fileName);
    } catch (IOException e) {
        
        e.printStackTrace();
    } 
}     

        
        Catalog catalog = catalogRepository.findById(id).orElseThrow(null) ; 

        List<Integer> technologiesIds = product.getTechnologiesIds() ; 
        List<Integer> resourcesIds = product.getResourcesIds() ; 

        Set<Resource>  res = new HashSet<>() ; //[res1,res2,res3]
        Set<Technology> tech = new HashSet<>() ; //[tech1,tech2]


        for (Integer technologyId : technologiesIds) {
            Technology technology = technologyRepository.findById(technologyId).orElse(null);
            tech.add(technology) ; 
        }
        for (Integer resourceId : resourcesIds){
            Resource resource = resourceRepository.findById(resourceId).orElseThrow(null);
            res.add(resource) ; 
        }
        

        if (product!=null){
        
            product.setCatalog(catalog);
            product.setResources(res);
            product.setTechnologies(tech);

            productRepository.save(product)  ; 
           
        }
       

    }

    @GetMapping("/api/getProducts")
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @DeleteMapping("/api/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        Product product = productRepository.findById(id).orElseThrow(null) ; 
        
        for (Technology technology : product.getTechnologies()) {
            technology.getProducts().remove(technology);
            technologyRepository.save(technology);
        }
        for (Resource resource : product.getResources()) {
            resource.getProducts().remove(resource);
            resourceRepository.save(resource);
        }
        productRepository.deleteById(id) ; 

    }

    @GetMapping("/api/product/{id}")
    public Optional<Product> findProductById(@PathVariable Integer id) {
        return productRepository.findById(id);

    }

    @PutMapping("/api/{catalog_id}/product/{product_id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Integer product_id,@PathVariable Integer catalog_id) {
       Product updating = productRepository.findById(product_id).orElseThrow(null) ; 
        if (product.getFileName()!=null && product.getData()!=null ){
            String fileName = product.getFileName();
            String base64String = product.getData();
            byte[] bytes = Base64.getDecoder().decode(base64String);
            Path path = Paths.get("src/main/resources/public/files/" + fileName);
         try {
            Files.write(path, bytes);
            product.setImagePath("http://localhost:8081/files/"+fileName);
        } catch (IOException e) {
            
            e.printStackTrace();
        } 
    }
    List<Integer> technologiesIds = product.getTechnologiesIds() ; 
    List<Integer> resourcesIds = product.getResourcesIds() ; 

    Set<Resource>  res = new HashSet<>() ; //[res1,res2,res3]
    Set<Technology> tech = new HashSet<>() ; //[tech1,tech2]


    for (Integer technologyId : technologiesIds) {
        Technology technology = technologyRepository.findById(technologyId).orElse(null);
        tech.add(technology) ; 
    }
    for (Integer resourceId : resourcesIds){
        Resource resource = resourceRepository.findById(resourceId).orElseThrow(null);
        res.add(resource) ; 
    }     
    
    if (updating!=null){
        if(product.getName()!=null)
           updating.setName(product.getName());
        if(product.getDescription()!=null)
           updating.setDescription(product.getDescription());
        if(product.getVersion()!=null)
           updating.setVersion(product.getVersion());
        if(product.getTestStatus()!=null)
           updating.setTestStatus(product.getTestStatus());
        
           updating.setResources(res);
           updating.setTechnologies(tech); 
        if(product.getImagePath()!=null)
           updating.setImagePath(product.getImagePath());  
        productRepository.save(updating)  ; 
    }
  
 
    

             productRepository.save(updating) ; 

        return ResponseEntity.ok(updating);
    }
}
