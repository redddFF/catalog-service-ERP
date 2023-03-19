package com.catalog.catalogservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    private Integer product_id;
    private String name;
    private String description;
    private String version;
    private String testStatus;

    @OneToMany(mappedBy="product")
    private Set<Resource> resources;
    
    @OneToMany(mappedBy="product")
    private Set<Technology> technologies;

    

    @ManyToOne
    @JoinColumn(name="catalog_id", nullable=false)
    private Catalog catalog;

   
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

   public Set<Resource> getResources(){
    return resources ; 
   }

   public Set<Technology> getTechnologies(){
    return technologies ; 
   }
  

}
