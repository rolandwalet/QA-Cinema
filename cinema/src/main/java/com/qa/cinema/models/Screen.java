package com.qa.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Screen {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "screen_type_id")
    private ScreenType screentype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScreenType getScreentype() {
        return screentype;
    }

    public void setScreentype(ScreenType screentype) {
        this.screentype = screentype;
    }
}
