package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "orderlines")
public class Orderlines {

	@EmbeddedId
	OrderlinesId orderLinesId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable = false, updatable = false)
	private Orders orders;
 
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "orderdate")
    private Calendar orderdDate;

    public Orderlines() {
	}

	public Orderlines(Integer orderlineid, Integer orderid, Integer prodId, Integer quantity, Calendar orderDate) {
		
		OrderlinesId orderLinesId = new OrderlinesId(orderlineid, orderid); 
		
		this.orderLinesId = orderLinesId;
		this.prodId = prodId;
		this.quantity = quantity;
		this.orderdDate = orderDate;
	}


    public OrderlinesId getOrderLinesId() {
		return orderLinesId;
	}

	public void setOrderLinesId(OrderlinesId orderLinesId) {
		this.orderLinesId = orderLinesId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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
