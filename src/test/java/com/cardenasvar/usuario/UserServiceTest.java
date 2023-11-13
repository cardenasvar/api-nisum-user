package com.cardenasvar.usuario;

import com.cardenasvar.usuario.dto.AuthRequest;
import com.cardenasvar.usuario.dto.UserRequest;
import com.cardenasvar.usuario.model.Phone;
import com.cardenasvar.usuario.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class UserServiceTest {

	@Autowired
  	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
    private JwtUtil jwtUtil;

	@Test
	void testAuthenticateOk() throws Exception {
		AuthRequest authRequest = createAuthRequest("Nisum2023");

		mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(authRequest))
			).andExpect(status().isOk()).andReturn();
	}

	@Test
	void testAuthenticateFailed() throws Exception {
		AuthRequest authRequest = createAuthRequest("Nisum202a3");

		mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(authRequest))
			).andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	void testCreateUserOk() throws Exception {
		UserRequest userRequest = createUserRequest();
        String jwtToken = jwtUtil.generateToken("jonathan@cardenas.org");

		mockMvc.perform(MockMvcRequestBuilders.post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer ".concat(jwtToken))
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userRequest))
			).andExpect(status().isOk()).andReturn();
	}

	private AuthRequest createAuthRequest(String password) {
		AuthRequest authRequest = new AuthRequest();
		authRequest.setUserName("jonathan@cardenas.org");
		authRequest.setPassword(password);
		return authRequest;
	}

	private UserRequest createUserRequest() {
		String name = "Ramiro Rodriguez";
		String email = "ramiro@rodriguez.org";
		String password = "Ahunter22";
		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = new Phone("number1", "city1", "country1");
		phones.add(phone);
		return new UserRequest(name, email, password, phones);
	}
}
