package com.example.Subject;

import com.example.Subject.models.SchoolSubject;
import com.example.Subject.repositories.SchoolSubjectRepository;
import com.example.Subject.services.SchoolSubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SubjectApplicationTests {

	@Autowired
		private MockMvc mockMvc;

	@Autowired
		private ObjectMapper objectMapper;

		@Test
		public void test_createSchoolSubject_with_SchoolSubject_shouldGiveOk200StatusOrAnException() 
			throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/subject")
						.content("{\"name\": \"Spanish\"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());


		}




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

