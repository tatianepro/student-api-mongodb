package com.github.tatianepro.studentapi;

import com.github.tatianepro.studentapi.entity.Address;
import com.github.tatianepro.studentapi.entity.Gender;
import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class StudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Student student1 = new Student(null,
					"Jamila",
					"Ahmed",
					"jahmed@gmail.com",
					Gender.FEMALE,
					new Address("England",
							"London",
							"NW9"),
					List.of("Computer Science", "Maths"),
					BigDecimal.TEN,
					LocalDateTime.now());

			Student student2 = new Student(null,
					"John",
					"Doe",
					"john.doe@yahoo.com",
					Gender.MALE,
					new Address("United States of America",
							"Miami",
							"33101"),
					List.of("Computer Engineering", "Tests"),
					BigDecimal.valueOf(35),
					LocalDateTime.now());

			repository.insert(student1);
			repository.insert(student2);

		};

	}

}
