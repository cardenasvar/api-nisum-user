package com.cardenasvar.usuario;

import com.cardenasvar.usuario.model.User;
import com.cardenasvar.usuario.repository.UserRepository;

import static com.cardenasvar.usuario.util.DateUtils.dateNow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	@Autowired
    private UserRepository userRepository;

	@PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
			new User(
				1l, 
				"Jonathan Cárdenas",
				"jonathan@cardenas.org",
				"Nisum2023",
				dateNow(),
				dateNow(),
				dateNow(),
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb25hdGhhbkBjYXJkZW5hcy5vcmciLCJleHAiOjE2OTk3OTUwNjgsImlhdCI6MTY5OTc1OTA2OH0.rr2_KfIO_exV2WU-UiIfQO-M0Om_yBLbYy1nen3DCx4",
				true)
			).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
