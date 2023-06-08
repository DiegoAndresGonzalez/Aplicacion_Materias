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

    public SchoolSubject updateSchoolSubject(Long id, SchoolSubject updatedSubject) {
        SchoolSubject existingSubject = schoolSubjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Materia no encontrada con el ID: " + id));

        existingSubject.setName(updatedSubject.getName());

        return schoolSubjectRepository.save(existingSubject);
    }
}
