package com.qa.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "showing_id")
    private Long showingId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "adult_tickets")
    private int adultTickets;
    @Column(name = "concession_tickets")
    private int concessionTickets;
    @Column(name = "child_tickets")
    private int childTickets;
    
    
    public Long getShowingId() {
		return showingId;
	}

	public void setShowingId(Long showingId) {
		this.showingId = showingId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

	public int getAdultTickets() {
		return adultTickets;
	}

	public void setAdultTickets(int adultTickets) {
		this.adultTickets = adultTickets;
	}

	public int getConcessionTickets() {
		return concessionTickets;
	}

	public void setConcessionTickets(int concessionTickets) {
		this.concessionTickets = concessionTickets;
	}

	public int getChildTickets() {
		return childTickets;
	}

	public void setChildTickets(int childTickets) {
		this.childTickets = childTickets;
	}
 
}
