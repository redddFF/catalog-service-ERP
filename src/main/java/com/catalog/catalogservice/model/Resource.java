package com.catalog.catalogservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "resource_id")
public class Resource implements Serializable {
    @Id
    private Integer resource_id ; 
    private String speciality  ;

   
    @ManyToMany
    @JoinColumn(referencedColumnName="product_id")
    Set<Product> products;
 
    public Integer getId() {
        return resource_id;
    }
    public void setId(Integer id) {
        this.resource_id = id;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    } 
    
}
