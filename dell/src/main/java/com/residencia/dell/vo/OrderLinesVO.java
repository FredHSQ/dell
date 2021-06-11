package com.residencia.dell.vo;

import java.util.Calendar;

import com.residencia.dell.entities.Orders;

public class OrderLinesVO {
    
    private Integer orderLineId;
    private Orders order;
    private Integer prodId;
    private Integer quantity;
    private Calendar orderdDate;

    public Integer getOrderLineId() {
        return this.orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }

    public Orders getOrder() {
        return this.order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Calendar getOrderdDate() {
        return this.orderdDate;
    }

    public void setOrderdDate(Calendar orderdDate) {
        this.orderdDate = orderdDate;
    }
    
    
}
