package com.example.Subject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SubjectApplicationTests {
@Autowired
private MockMvc mockMvc;
	@Test
	public void test_createSchoolSubject_with_SchoolSubject_shouldGiveOk200StatusOrAnException() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/subject")
						.content("{\"name\": \"Spanish\"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());


	}

}
