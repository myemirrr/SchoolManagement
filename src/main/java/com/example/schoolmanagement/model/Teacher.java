package com.example.schoolmanagement.model;

import com.example.schoolmanagement.model.Role;
import jakarta.persistence.Table;

@Table(name = "teachers")
public class Teacher {
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl; // Öğretmenin fotoğrafının URL'si
    private String cvUrl; // Öğretmenin CV'sinin URL'si
    private Role role; // Öğretmenin rolü

    // Constructor
    public Teacher(String firstName, String lastName, String email, String photoUrl, String cvUrl, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photoUrl = photoUrl;
        this.cvUrl = cvUrl;
        this.role = role;
    }

    // Getter ve Setter metotları
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // toString metodu (opsiyonel)
    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", cvUrl='" + cvUrl + '\'' +
                ", role=" + role +
                '}';
    }
}
