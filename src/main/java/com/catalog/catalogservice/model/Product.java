package com.catalog.catalogservice.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonSerialize
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "product_id")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer product_id;
    private String name;
    private String description;
    private String version;
    private String testStatus;
    private String imagePath ; 
   
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="catalog_id")
    @JsonIgnoreProperties("products")
    private Catalog catalog;

 
    
    @ManyToMany
    @JoinColumn(referencedColumnName="technology_id")
    Set<Technology> technologies;
    
   
    @ManyToMany
    @JoinColumn(referencedColumnName="resource_id")
    Set<Resource> resources;
    
 
    @Transient
    private List<Integer> technologiesIds ;
    @Transient
    private List<Integer> resourcesIds ;
    @Transient
    String fileName ; 
    @Transient
    String data ; 


    public Integer getId() {
        return product_id;
    }

    public void setId(Integer id) {
        this.product_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

   public void setCatalog(Catalog catalog){
    this.catalog=catalog ; 
    }

}
