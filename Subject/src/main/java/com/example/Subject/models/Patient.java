package com.example.Subject.models;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private LocalDate last_visit;
    private Boolean private_social;
    private String allergies;
    private String observations;
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

    public LocalDate getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(LocalDate last_visit) {
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