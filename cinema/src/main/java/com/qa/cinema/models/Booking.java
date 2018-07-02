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
    @ManyToOne
    @Column(name = "showing_id")
    private Showing showing;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "adult_tickets")
    private int adultTickets
    @Column(name = "concession_tickets")
    private int concessionTickets
    @Column(name = "child_tickets")
    private int childTickets
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public int adultTickets() {
        return adultTickets;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
