package com.example.Subject.controllers;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.repositories.SchoolAdminUserRepository;
import com.example.Subject.repositories.SchoolSubjectRepository;
import com.example.Subject.services.SchoolSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/subject")
public class SchoolSubjectController {
    @Autowired
    private SchoolSubjectService schoolSubjectService;

    @GetMapping()
    public ArrayList<SchoolSubject> getSchoolSubject(){
        return schoolSubjectService.getSchoolSubject();
    }

    @PostMapping()
    public SchoolSubject createSubject(@RequestBody SchoolSubject subject){
        return this.schoolSubjectService.createSubject(subject);
    }
}
