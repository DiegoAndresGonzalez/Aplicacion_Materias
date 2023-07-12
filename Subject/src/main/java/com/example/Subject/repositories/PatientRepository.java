package com.example.Subject.repositories;

import com.example.Subject.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT p.lastVisit FROM Patient p WHERE p.document = :document")
    List<LocalDate> findLastVisitByDocument(Integer document);

    List<Patient> findAllByOrderByIdAsc();

    List<Patient> findAllByAllergiesIsNotNull();

    List<Patient> findAllBySocialSecurityIsNotNull();
}