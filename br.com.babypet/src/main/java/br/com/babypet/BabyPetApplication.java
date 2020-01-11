package br.com.babypet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BabyPetApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BabyPetApplication.class, args);
		
		System.out.println("**************");
		System.out.println("Aplicação rodando!");
	}
	
}
