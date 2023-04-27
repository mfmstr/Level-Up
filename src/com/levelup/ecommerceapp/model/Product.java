package com.levelup.ecommerceapp.model;

public class Product {
	
	// ეს კლასი წარმოადგენს პროდუქტის მოდელს და შეიცავს ყველა იმ ველს თუ მეთოდს, რომელიც პროდუქტს ჭირდება.
	
	private int id;
	
	private String name;
	private int price;
	private int balance;
	private int orderCounter;
	
	public Product(int id, String name, int price) {
		
		this.orderCounter = 0;
		this.balance = 0;
		this.id = id;
		this.name = name;
		this.price = price;
		
	}

	public int getOrderCounter() {
		return orderCounter;
	}

	public void setOrderCounter(int orderCounter) {
		this.orderCounter = orderCounter;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", balance=" + balance + "]";
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
