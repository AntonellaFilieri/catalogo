package com.shop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order extends LinkedList<OrderItem>{

	private String orderName;
	private OrderStatus orderStatus;
	private PaymentMode paymentMode; 

	public Order() {
		
	}

	public Order(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderName() {
		return orderName;
	}

//	public int getOrderItemCount() {
//		return orderItemList.size();
//	}
//
//	public void add(OrderItem orderItem) {
//		orderItemList.add(orderItem);
//	}

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

//	public List<OrderItem> getOrderItemList() {
//		return orderItemList;
//	}
//
//	public void setOrderItemList(List<OrderItem> orderItemList) {
//		this.orderItemList = orderItemList;
//	}
}
