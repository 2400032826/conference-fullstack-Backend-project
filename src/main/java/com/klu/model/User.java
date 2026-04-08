package com.klu.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    // 🔥 PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 BASIC FIELDS
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    // 🔥 OTP + VERIFY
    private String otp;

    private boolean verified;

    // ================= GETTERS =================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getOtp() {
        return otp;
    }

    public boolean isVerified() {
        return verified;
    }

    // ================= SETTERS =================

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}