package com.residencia.dell.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderlinesId implements Serializable { 
    
    private static final long serialVersionUID = -1L;

    private Integer orderlineid;
    private Integer orderid;


    public OrderlinesId() {
    }

    public OrderlinesId(Integer orderlineid, Integer orderid) {
        this.orderlineid = orderlineid;
        this.orderid = orderid;
    }

    public Integer getOrderLineId() {
        return this.orderlineid;
    }

    public void setOrderLineId(Integer orderlineid) {
        this.orderlineid = orderlineid;
    }

    public Integer getOrderid() {
        return this.orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderlinesId)) {
            return false;
        }
        OrderlinesId orderlinesId = (OrderlinesId) o;
        return Objects.equals(orderlineid, orderlinesId.orderlineid) && Objects.equals(orderid, orderlinesId.orderid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderlineid, orderid);
    }
   
}
