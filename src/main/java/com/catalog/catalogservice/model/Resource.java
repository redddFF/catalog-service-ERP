package com.catalog.catalogservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resource implements Serializable {
    @Id
    private Integer id ; 
    private String speciality  ;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    } 
    
}
