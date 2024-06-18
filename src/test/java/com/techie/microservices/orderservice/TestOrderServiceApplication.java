package com.techie.microservices.orderservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestOrderServiceApplication {

	@Bean
	@ServiceConnection
	MySQLContainer<?> mysqlContainer() {
		MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:latest"));
//				.withDatabaseName("testdb")
//				.withUsername("testuser")
//				.withPassword("testpass");
		mysql.start();
		return mysql;
	}

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	public static void main(String[] args) {
	}
}
