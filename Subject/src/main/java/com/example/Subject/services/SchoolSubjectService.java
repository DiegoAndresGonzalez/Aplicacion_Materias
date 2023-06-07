package com.example.Subject.services;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SchoolSubjectService {
    @Autowired
    SchoolSubjectRepository schoolSubjectRepository;

    public SchoolSubject createSchoolSubject(SchoolSubject subject){
        return schoolSubjectRepository.save(subject);
    }
}
