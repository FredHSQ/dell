package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "category")
    private Integer category;

    @Column(name = "title")
    private String title;

    @Column(name = "actor")
    private String actor;

    @Column(name = "price")
    private Double price;

    @Column(name = "special")
    private Integer special;

    @Column(name = "common_prod_id")
    private Integer common_prod_id;
    

    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return this.actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSpecial() {
        return this.special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    }

    public Integer getCommon_prod_id() {
        return this.common_prod_id;
    }

    public void setCommon_prod_id(Integer common_prod_id) {
        this.common_prod_id = common_prod_id;
    }
}
