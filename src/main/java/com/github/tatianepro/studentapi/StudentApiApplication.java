package com.github.tatianepro.studentapi;

import com.github.tatianepro.studentapi.entity.Address;
import com.github.tatianepro.studentapi.entity.Gender;
import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class StudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			String studentEmail = "jahmed@gmail.com";
			Student student = new Student(null,
					"Jamila",
					"Ahmed",
					studentEmail,
					Gender.FEMALE,
					new Address("England",
							"London",
							"NW9"),
					List.of("Computer Science", "Maths"),
					BigDecimal.TEN,
					LocalDateTime.now());

			repository.findStudentByEmail(studentEmail)
					.ifPresentOrElse(
							s -> System.out.println("Student already exists: [" + student + "]"),
							() -> { System.out.println("Inserting new student: " + student);
									repository.insert(student); }
					);

//			usingMongoTemplateAndQuery(repository, mongoTemplate, studentEmail, student);

		};

	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String studentEmail, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(studentEmail));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 1) {
			throw new IllegalStateException("the email \'" + studentEmail + "\' already exists in our database");
		}

		if (students.isEmpty()) {
			System.out.println("Inserting new student: " + student);
			repository.insert(student);
		} else {
			System.out.println("Student already exists: [" + student + "]");
		}
	}

}
