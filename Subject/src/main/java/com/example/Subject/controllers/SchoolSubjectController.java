package com.example.Subject.controllers;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.services.SchoolSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SchoolSubjectController {
    @Autowired
    SchoolSubjectService  schoolSubjectService;

    @PostMapping()
    public SchoolSubject createSchoolSubject(@RequestBody SchoolSubject subject){
        return this.schoolSubjectService.createSchoolSubject(subject);
    }

}
