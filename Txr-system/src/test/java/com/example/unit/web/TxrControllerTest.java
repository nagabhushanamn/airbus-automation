package com.example.unit.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.model.Account;
import com.example.service.TxrService;
import com.example.web.TxrController;
import com.example.web.TxrRequest;
import com.example.web.TxrResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Tag("unit")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = { TxrController.class })
public class TxrControllerTest {

//	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private TxrService txrService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void txrTest() throws Exception {

		TxrRequest request = new TxrRequest();
		request.setAmount(100.00);
		request.setFromAccNumber("1");
		request.setToAccNumber("2");

		when(txrService.transfer(request.getAmount(), request.getFromAccNumber(), request.getToAccNumber()))
				.thenReturn(new Account("1", 900));

		String json = objectMapper.writeValueAsString(request);

		MvcResult result = mockMvc.perform(post("/txr").content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		TxrResponse response = objectMapper.readValue(resultContent, TxrResponse.class);

		assertEquals("Transfer success", response.getMessage());

		verify(txrService).transfer(request.getAmount(), request.getFromAccNumber(), request.getToAccNumber());

	}

}
