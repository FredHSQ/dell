package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class NFVO {
    
    private BigDecimal netAmount;
    private BigDecimal totalAmount;
    private Calendar orderDate;
    private Integer orderId;
    private String firstName;
    private String lastName;
    private List<ItemOrderLinesVO> products;


    public List<ItemOrderLinesVO> getListItemOrderLinesVO() {
        return this.products;
    }

    public void setListItemOrderLinesVO(List<ItemOrderLinesVO> products) {
        this.products = products;
    }

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Calendar getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
