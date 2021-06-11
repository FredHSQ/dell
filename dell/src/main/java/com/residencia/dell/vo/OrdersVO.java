package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;



public class OrdersVO {

	
    private Integer orderid;
    private Calendar orderDate;
    private Integer customers;
    private BigDecimal netAmount;
    private BigDecimal tax;
    private BigDecimal totalAmount;
	private List<OrderLinesVO> listOrderLinesVO;

	public List<OrderLinesVO> getListOrderLinesVO() {
		return this.listOrderLinesVO;
	}

	public void setListOrderLinesVO(List<OrderLinesVO> listOrderLinesVO) {
		this.listOrderLinesVO = listOrderLinesVO;
	}

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

	public Integer getCustomers() {
		return this.customers;
	}

	public void setCustomers(Integer customers) {
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
