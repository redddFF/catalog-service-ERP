package com.catalog.catalogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.catalog.catalogservice.model.Catalog;
import com.catalog.catalogservice.repository.CatalogRepository;

@SpringBootApplication
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
	@Bean
    CommandLineRunner start(CatalogRepository catalogRepository){
        return args -> {
            catalogRepository.save(new Catalog(1,"Insurance",null));
            catalogRepository.save(new Catalog(2,"Banking",null));
            catalogRepository.save(new Catalog(3,"Insurance",null));
        };
	}
}
