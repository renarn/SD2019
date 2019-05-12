package com.sd.tud.PatientPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientPortalApplication.class, args);
		
		System.out.println(System.lineSeparator() + "Patient Portal is up and running ... YAY :D" + System.lineSeparator());
		
	}

}
