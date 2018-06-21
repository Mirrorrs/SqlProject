package com.hansoma.model;

public class HWXX {
	private int id;
	private String name;
	private int storage;
	private int price;
	private String owner;
	private java.sql.Date inDate;
	private java.sql.Date outDate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public java.sql.Date getInDate() {
		return inDate;
	}
	public void setInDate(java.sql.Date inDate) {
		this.inDate = inDate;
	}
	public java.sql.Date getOutDate() {
		return outDate;
	}
	public void setOutDate(java.sql.Date outDate) {
		this.outDate = outDate;
	}
	
	
}
