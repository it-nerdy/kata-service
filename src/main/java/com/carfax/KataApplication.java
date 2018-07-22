package com.carfax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Main class to start the Kata Rest Service.
 * 
 * @author Mallikarjun Nuti
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class KataApplication {
	/**
	 * Main method to invoke Spring boot application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(KataApplication.class, args);
	}
}
