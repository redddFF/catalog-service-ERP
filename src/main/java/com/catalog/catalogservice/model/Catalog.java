package com.catalog.catalogservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "catalog_id")
public class Catalog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer catalog_id;
    private String businessLine;
    private String description ; 
    
  
    
   @OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonBackReference
   private Set<Product> products; 

    public Integer getId() {
        return catalog_id;
    }

    public void setId(Integer id) {
        this.catalog_id = id;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }
  /*   public void setProduct(Product product){
        this.products.add(product) ;
    }
    public Set<Product> getProducts(){
        return this.products ; 
    } */

 

}
