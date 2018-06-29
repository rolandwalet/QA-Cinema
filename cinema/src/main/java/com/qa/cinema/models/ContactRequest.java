package com.qa.cinema.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contact_request")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContactRequest {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="customer_message")
	private String customerMessage;
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getCustomerMessage() {
		return customerMessage;
	}
	
	public void setCustomerMessage(String customerMessage) {
		this.customerMessage = customerMessage;
	}
	
	public long getId() {
		return id;
	}
	
	
}
