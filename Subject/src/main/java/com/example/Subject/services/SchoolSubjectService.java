package com.example.Subject.services;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Service
public
class SchoolSubjectService {
    @Autowired
    SchoolSubjectRepository schoolSubjectRepository;

    public ArrayList<SchoolSubject> getSchoolSubject(){
        return(ArrayList<SchoolSubject>) schoolSubjectRepository.findAll();
    }
    public SchoolSubject createSubject(SchoolSubject subject){
        return schoolSubjectRepository.save(subject);
    }
}
