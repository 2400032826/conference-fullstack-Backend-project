package com.klu.model;

import jakarta.persistence.*;

@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String abstractText;

    private String fileName;

    private String filePath;   // ✅ ADD THIS

    private String status;
    

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {   // ✅ ADD THIS
        return filePath;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {   // ✅ ADD THIS
        this.filePath = filePath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}