package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderid;

    @Column(name = "orderdate")
    private Calendar orderDate;

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName="customerid")
    private Customers customers;

    @Digits (integer = 4, fraction = 2,  message = "NetAmount tem que ser menor que 10.000 reais, e só aceita duas casas decimais")
    @Column(name = "netamount")
    private BigDecimal netAmount;

    @Digits (integer = 4, fraction = 2,  message = "Tax tem que ser menor que 10.000 reais, e só aceita duas casas decimais")
    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "totalamount")
    private BigDecimal totalAmount;
    
    public Integer getOrderid() {
        return this.orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Calendar getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

}
