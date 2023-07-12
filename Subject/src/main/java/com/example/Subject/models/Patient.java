package com.example.Subject.models;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer document;
    private Integer phone;

    @Temporal(TemporalType.DATE)
    private LocalDate lastVisit;
    private String socialSecurity;
    private String allergies;
    private String observations;
    public String queryToString(){
        return "ID: " + id +
                "\nName: " + name +
                "\nDocument: " + document +
                "\nPhone: " + phone +
                "\nLast visit: " + lastVisit +
                "\nPrivate social: " + socialSecurity +
                "\nAllergies: " + allergies +
                "\nObservations " + observations +
                "\n-----------------------------------------------";
    }

    public Patient(Long id, String name, Integer document, Integer phone, LocalDate last_visit, String private_social, String allergies, String observations) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.lastVisit = lastVisit;
        this.socialSecurity = private_social;
        this.allergies = allergies;
        this.observations = observations;
    }

    public Patient() {

    }

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

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setPrivate_social(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}