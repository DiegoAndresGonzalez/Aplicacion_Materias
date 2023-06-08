package com.example.Subject;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.repositories.SchoolSubjectRepository;
import com.example.Subject.services.SchoolSubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class UpdateSubjectServiceTest {


    @Mock
    private SchoolSubjectRepository schoolSubjectRepository;

    @InjectMocks
    private SchoolSubjectService schoolSubjectService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_updateSchoolSubject_withSchoolSubject_shouldReturnStatusOk(){

        Long subjectId = 1L;
        String updatedName = "Nuevo nombre";

        SchoolSubject existingSubject = new SchoolSubject();
        existingSubject.setId(subjectId);
        existingSubject.setName("fisica");

        SchoolSubject updatedSubject = new SchoolSubject();
        updatedSubject.setName(updatedName);

        when(schoolSubjectRepository.findById(subjectId)).thenReturn(Optional.of(existingSubject));
        when(schoolSubjectRepository.save(existingSubject)).thenReturn(existingSubject);

        SchoolSubject result = schoolSubjectService.updateSchoolSubject(subjectId, updatedSubject);

        assertThat(result.getName()).isEqualTo(updatedName);
    }
}
