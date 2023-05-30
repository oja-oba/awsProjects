package com.ojaoba.springbootpostgres;

import com.ojaoba.springbootpostgres.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController

public class  SpringBootPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresApplication.class, args);
	}





}
