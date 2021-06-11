package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_id")
    private Integer prodid;

    @Column(name="quan_in_stock")
    private Integer quanInStock;

    @Column(name="sales")
    private Integer sales;


    public Integer getProdid() {
        return this.prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Integer getQuanInStock() {
        return this.quanInStock;
    }

    public void setQuanInStock(Integer quanInStock) {
        this.quanInStock = quanInStock;
    }

    public Integer getSales() {
        return this.sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

}
