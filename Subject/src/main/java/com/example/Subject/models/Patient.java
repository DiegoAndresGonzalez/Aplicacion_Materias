package com.example.Subject.models;

import jakarta.persistence.*;

import java.util.Date;

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
    private Date last_visit;
    private Boolean private_social;
    private String allergies;
    private String observations;

    public Patient(Long id, String name, Integer document, Integer phone, Date last_visit, Boolean private_social, String allergies, String observations) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.last_visit = last_visit;
        this.private_social = private_social;
        this.allergies = allergies;
        this.observations = observations;
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

    public Date getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(Date last_visit) {
        this.last_visit = last_visit;
    }

    public Boolean getPrivate_social() {
        return private_social;
    }

    public void setPrivate_social(Boolean private_social) {
        this.private_social = private_social;
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
