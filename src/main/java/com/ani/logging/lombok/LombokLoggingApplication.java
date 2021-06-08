package com.ani.logging.lombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class LombokLoggingApplication {

	// Log4j, Logback, SLF4j
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LombokLoggingApplication.class, args);

		final Logger logger = LoggerFactory.getLogger(LombokLoggingApplication.class);
		logger.info("Logging"); // not good

		// Log4j - in files, databases, JMS, SMTP -> 1.x, 2.0,
		// Logback -

		Device dv = new Device();
		dv.setMfg("abc");
		dv.setDvId(12L);
		dv.setMfgDt(LocalDate.now());

		Device dv1 = new Device(
				10L,
				"btr",
				LocalDate.now()
		);
		logger.info(dv.toString());

		DataService ser = ctx.getBean(DataService.class);
		ser.publishData();
	}
}
