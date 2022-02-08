package com.mouritech.onlineshoppingsystem.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;
	
	private int quantity;
	private double price;
	private LocalDate ordered_on;
	private String order_status;
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name="prodId", nullable=false)
    private Product product;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name="cartId", nullable=false)
    private AddToCart cart;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="custId")
    private Customer customer;

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getOrdered_on() {
		return ordered_on;
	}

	public void setOrdered_on(LocalDate ordered_on) {
		this.ordered_on = ordered_on;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AddToCart getCart() {
		return cart;
	}

	public void setCart(AddToCart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(long order_id, int quantity, double price, LocalDate ordered_on, String order_status, Product product,
			AddToCart cart, Customer customer) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.price = price;
		this.ordered_on = ordered_on;
		this.order_status = order_status;
		this.product = product;
		this.cart = cart;
		this.customer = customer;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int quantity, double price, LocalDate ordered_on, String order_status, Product product, AddToCart cart,
			Customer customer) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.ordered_on = ordered_on;
		this.order_status = order_status;
		this.product = product;
		this.cart = cart;
		this.customer = customer;
	}

}
