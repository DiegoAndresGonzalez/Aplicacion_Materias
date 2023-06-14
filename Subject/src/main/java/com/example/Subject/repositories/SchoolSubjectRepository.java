package com.example.Subject.repositories;

import com.example.Subject.models.SchoolSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface SchoolSubjectRepository
        extends CrudRepository<SchoolSubject, Long> {
}
