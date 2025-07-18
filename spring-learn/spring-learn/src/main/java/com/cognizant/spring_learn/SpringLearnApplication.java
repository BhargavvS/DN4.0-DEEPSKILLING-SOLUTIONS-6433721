package com.cognizant.spring_learn;

//import org.junit.platform.commons.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {
	public static <SimpleDateFormat, ParseException> void displayDate(){
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

// use correct bean name (e.g., dateFormat1)
		SimpleDateFormat format = context.getBean("dateFormat1", SimpleDateFormat.class);

		try {
			Date date = format.parse("31/12/2018");
			System.out.println("Parsed Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SpringLearnApplication.class);


	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
//		LOGGER.debug("Country : {}", country.toString());
	}


	public static void main(String[] args) {

		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();

	}


}
