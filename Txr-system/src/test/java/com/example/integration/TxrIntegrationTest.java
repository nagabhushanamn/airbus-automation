package com.example.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.Application;
import com.example.web.TxrRequest;
import com.example.web.TxrResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK,classes = {Application.class})
@AutoConfigureMockMvc
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TxrIntegrationTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    
    @Test
	public void txrTest() throws Exception {

		TxrRequest request = new TxrRequest();
		request.setAmount(100.00);
		request.setFromAccNumber("1");
		request.setToAccNumber("2");


		String json = objectMapper.writeValueAsString(request);

		MvcResult result = mockMvc.perform(post("/txr").content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		TxrResponse response = objectMapper.readValue(resultContent, TxrResponse.class);

		assertEquals("Transfer success", response.getMessage());


	}

	
	

}
