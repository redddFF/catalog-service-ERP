package com.catalog.catalogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.catalog.catalogservice.model.Catalog;
import com.catalog.catalogservice.model.Resource;
import com.catalog.catalogservice.model.Technology;
import com.catalog.catalogservice.repository.CatalogRepository;
import com.catalog.catalogservice.repository.ResourceRepository;
import com.catalog.catalogservice.repository.TechnologyRepository;

@SpringBootApplication
public class CatalogServiceApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
	@Bean
    CommandLineRunner start(CatalogRepository catalogRepository,TechnologyRepository technologyRepository,ResourceRepository resourceRepository){
        return args -> {
            catalogRepository.save(new Catalog(1,"Insurance",null));
            catalogRepository.save(new Catalog(2,"Banking",null));
             technologyRepository.save(new Technology(1,"AngularJs","Front-end",null)) ; 
            technologyRepository.save(new Technology(2,"VueJS","Front-end",null)) ; 
            technologyRepository.save(new Technology(3,"ReactJs","Front-end",null)) ; 
            technologyRepository.save(new Technology(4,"Java","Back-end",null)) ;
            technologyRepository.save(new Technology(5,"Python","Back-end",null)) ;
            technologyRepository.save(new Technology(6,"Laravel","Back-end",null)) ;
            technologyRepository.save(new Technology(7,"Nodejs","Back-end",null)) ;
            technologyRepository.save(new Technology(8,"MySQL","Database",null)) ;
            technologyRepository.save(new Technology(9,"PostgreSQL","Database",null)) ;
            technologyRepository.save(new Technology(10,"MongoDB","Database",null)) ;
            technologyRepository.save(new Technology(11,"Oracle","Database",null)) ;
            technologyRepository.save(new Technology(12,"MariaDB","Database",null)) ;
            resourceRepository.save(new Resource(1,"Front-end developer",null)) ; 
            resourceRepository.save(new Resource(2,"Back-end developer",null)) ; 
            resourceRepository.save(new Resource(3,"DevOps engineer",null)) ;   
        };
	}
}
