package com.mouritech.onlineshoppingsystem.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name =  "cart")
public class AddToCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	private int quantity;
	private double price;
	private LocalDate added_date;
	
	    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
	    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	    private Set<Product> products = new HashSet<>();

	public long getCartId() {
		return cartId;
	}

	public void CartId(long cartId) {
		this.cartId = cartId;
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

	public LocalDate getAdded_date() {
		return added_date;
	}

	public void setAdded_date(LocalDate added_date) {
		this.added_date = added_date;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public AddToCart(int quantity, double price, LocalDate added_date, Set<Product> products) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.added_date = added_date;
		this.products = products;
	}

	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
