package com.catalog.catalogservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Catalog implements Serializable {
    @Id
    private Integer catalog_id;
    private String businessLine;

    @OneToMany(mappedBy = "catalog")
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

    public Set<Product> getProduct() {
        return products;
    }

    public void setProduct(Set<Product> products) {
        this.products = products;
    }

}
