package com.residencia.dell.vo;

public class ItemOrderLinesVO {
    
    private Integer prodId;
    private Integer quantity;
    private String title;

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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
