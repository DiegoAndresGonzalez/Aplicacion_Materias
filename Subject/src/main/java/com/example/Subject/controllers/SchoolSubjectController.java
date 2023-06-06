package com.example.Subject.controllers;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.repositories.SchoolAdminUserRepository;
import com.example.Subject.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SchoolSubjectController {
    @Autowired
    private SchoolSubjectRepository schoolSubjectRepository;

    @GetMapping()
    public ArrayList<SchoolSubject> getSchoolSubject(){
        return
    }
}
