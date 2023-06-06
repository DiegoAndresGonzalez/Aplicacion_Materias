package com.example.Subject.repositories;

import com.example.Subject.models.SchoolSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, Long> {
}
