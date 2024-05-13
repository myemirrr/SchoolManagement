package com.example.schoolmanagement.entity;

public class Homework {
    private Long id;
    private String description;
    private String deadline;
    private String subject;
    // diğer gerekli alanlar

    public Homework() {
    }

    public Homework(Long id, String description, String deadline, String subject) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.subject = subject;
        // diğer gerekli alanlar için set ediciler
    }

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // diğer gerekli alanlar için Getter ve Setter metotları
}
