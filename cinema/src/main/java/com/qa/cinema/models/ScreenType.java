package com.qa.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "screen_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ScreenType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_of_seats")
    private Integer numberOfSeats;
    @Column(name = "seating_plan")
    private String seatingPlan;
    @Column(name = "decor")
    private String decor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getSeatingPlan() {
        return seatingPlan;
    }

    public void setSeatingPlan(String seatingPlan) {
        this.seatingPlan = seatingPlan;
    }

    public String getDecor() {
        return decor;
    }

    public void setDecor(String decor) {
        this.decor = decor;
    }
}
