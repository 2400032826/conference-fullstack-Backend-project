package com.klu.model;

import jakarta.persistence.*;

@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String date;
    private String location;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}