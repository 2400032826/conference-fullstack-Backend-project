package com.klu.model;

import jakarta.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long conferenceId;
    private String email;

    // getters & setters
    public Long getId() { return id; }

    public Long getConferenceId() { return conferenceId; }
    public void setConferenceId(Long conferenceId) { this.conferenceId = conferenceId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}