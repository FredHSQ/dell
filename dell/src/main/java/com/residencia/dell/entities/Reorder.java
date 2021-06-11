package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reorder")
public class Reorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "prod_id")
    private Integer prod_id;

    @Column(name = "date_low")
    private Calendar date_low;

    @Column(name = "quan_low")
    private Integer quan_low;

    @Column(name = "date_reordered")
    private Calendar date_reordered;

    @Column(name = "quan_reordered")
    private Integer quan_reordered;

    @Column(name = "date_expected")
    private Calendar date_expected;


    public Integer getProd_id() {
        return this.prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public Calendar getDate_low() {
        return this.date_low;
    }

    public void setDate_low(Calendar date_low) {
        this.date_low = date_low;
    }

    public Integer getQuan_low() {
        return this.quan_low;
    }

    public void setQuan_low(Integer quan_low) {
        this.quan_low = quan_low;
    }

    public Calendar getDate_reordered() {
        return this.date_reordered;
    }

    public void setDate_reordered(Calendar date_reordered) {
        this.date_reordered = date_reordered;
    }

    public Integer getQuan_reordered() {
        return this.quan_reordered;
    }

    public void setQuan_reordered(Integer quan_reordered) {
        this.quan_reordered = quan_reordered;
    }

    public Calendar getDate_expected() {
        return this.date_expected;
    }

    public void setDate_expected(Calendar date_expected) {
        this.date_expected = date_expected;
    }
}
