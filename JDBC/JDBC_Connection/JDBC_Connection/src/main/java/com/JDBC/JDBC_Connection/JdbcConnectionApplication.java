package com.JDBC.JDBC_Connection;

import com.JDBC.JDBC_Connection.model.Alien;
import com.JDBC.JDBC_Connection.repository.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class JdbcConnectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JdbcConnectionApplication.class, args);
		System.out.println("Naveen");

		Alien a = context.getBean(Alien.class);
		a.setId(100);
		a.setName("Naveen");
		a.setTech("Java");

		AlienRepository repository = context.getBean(AlienRepository.class);
		repository.save(a);

		System.out.println(repository.getAllAliens());



	}

}
