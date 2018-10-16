package com.shop;

import java.util.LinkedList;

import com.shop.tax.SaleTaxesCalculator;

public class Order extends LinkedList<OrderItem> {

	private String orderName;
	private OrderStatus orderStatus;
	private PaymentMode paymentMode;
	private SaleTaxesCalculator saleTaxesCalculator;

	public Order() {
		this.saleTaxesCalculator = new SaleTaxesCalculator();
	}

	public Order(String orderName) {
		this.orderName = orderName;
	}

	public Order(SaleTaxesCalculator saleTaxesCalculator) {
		this.saleTaxesCalculator = saleTaxesCalculator;
	}

	public String getOrderName() {
		return orderName;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public SaleTaxesCalculator getSaleTaxesCalculator() {
		return saleTaxesCalculator;
	}

	public void setSaleTaxesCalculator(SaleTaxesCalculator saleTaxesCalculator) {
		this.saleTaxesCalculator = saleTaxesCalculator;
	}

}
