package com.texoit.challenge.challenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


@SpringBootTest(classes = ChallengeApplication.class,
	webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
class ChallengeApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Autowired
	private MovieRepository repository;

	@BeforeAll
	public void populateDatabase(){
		repository.save(new Movie(1990, "FILME TESTE A", "STUDIO A", "PRODUCER A", true));
		repository.save(new Movie(1990, "FILME TESTE B", "STUDIO B", "PRODUCER B", false));
		repository.save(new Movie(1991, "FILME TESTE C", "STUDIO B", "PRODUCER B", true));
		repository.save(new Movie(1991, "FILME TESTE D", "STUDIO A", "PRODUCER A", false));
		repository.save(new Movie(1992, "FILME TESTE E", "STUDIO B", "PRODUCER B", true));
		repository.save(new Movie(1992, "FILME TESTE F", "STUDIO A", "PRODUCER A", false));
		repository.save(new Movie(2000, "FILME TESTE G", "STUDIO B", "PRODUCER B", false));
		repository.save(new Movie(2000, "FILME TESTE H", "STUDIO A", "PRODUCER A", true));
	}
	
	@Test
	void checkWinnerInterval() {
		try {
			mockMvc.perform(get("/awardIntervals"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.max[0]", hasEntry("producer","PRODUCER A")))
				.andExpect(jsonPath("$.max[0]", hasEntry("interval", 10)))
				.andExpect(jsonPath("$.min[0]", hasEntry("producer", "PRODUCER B")))
				.andExpect(jsonPath("$.min[0]", hasEntry("interval", 1)));
				
				
		}
		catch (Exception e) {
		
		}
	}

}
