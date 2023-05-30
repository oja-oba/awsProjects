package com.ojaoba.mongoDb;

import com.ojaoba.mongoDb.model.Address;
import com.ojaoba.mongoDb.model.Gender;
import com.ojaoba.mongoDb.model.Student;
import com.ojaoba.mongoDb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){

	return args -> {

		Address address = new Address(
				"england",
				"London",
				"NE9"

		);

		String email = "ore@aol.com";

		Student student = new Student(
				"akin wale",
				"ore",
				email,
				Gender.MALE,
				address,
				List.of("Computer science","Math"),
				BigDecimal.TEN,
				LocalDateTime.now()


		);

		// usingMongoQueryAndTemplate(repository, mongoTemplate, email, student);

		repository.findStudentByEmail(email)
				.ifPresentOrElse(s->
				{
					System.out.println(s + " already exists ");

				}, () -> {
					System.out.println("Inserting student " + student);

					repository.insert(student);

				});

	};


	}

	private static void usingMongoQueryAndTemplate(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students =	mongoTemplate.find(query, Student.class);

		if(students.size() >1){

			throw new IllegalStateException("found many student with the email");


		}

		if (students.isEmpty()){
			System.out.println("Inserting student " + student);

			repository.insert(student);
		} else {
			System.out.println(student + " already exists ");
		}
	}


}
