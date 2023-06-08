package com.example.Subject.controllers;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.services.SchoolSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/subject")
public
class SchoolSubjectController {

    @Autowired
    SchoolSubjectService  schoolSubjectService;

    @PostMapping()
    public SchoolSubject createSchoolSubject(@RequestBody SchoolSubject subject){
        return this.schoolSubjectService.createSchoolSubject(subject);
    }

    @PutMapping("/{id}")
    public SchoolSubject updateSchoolSubject(@PathVariable Long id, @RequestBody SchoolSubject subject) {
        return schoolSubjectService.updateSchoolSubject(id, subject);
    }
}
