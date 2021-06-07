package com.ani.logging.lombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LombokLoggingApplication {

	// Log4j, Logback, SLF4j
	public static void main(String[] args) {
		SpringApplication.run(LombokLoggingApplication.class, args);
		System.out.println("Logging"); // not good

		// Log4j - in files, databases, JMS, SMTP -> 1.x, 2.0,
		// Logback -
	}
}
