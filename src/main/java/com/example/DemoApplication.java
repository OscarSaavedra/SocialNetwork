package com.example;

import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(DemoApplication.class, args);

		SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);

        testSocialNetwork(socialNetworkService);
	}

    private static void testSocialNetwork(SocialNetworkService socialNetworkService) {
        Persona novia=new Persona();
        socialNetworkService.addPerson(novia);

        Persona persona = new Persona();
        persona.setNombre("Ivan");
        persona.setAge(23);
        socialNetworkService.addPerson(persona);

        Persona persona2 = new Persona();
        persona2.setNombre("Dimple");
        persona2.setAge(21);
        socialNetworkService.addPerson(persona2);

        socialNetworkService.addPareja(persona,persona2);
        System.out.println("La pareja de la persona");
        System.out.println(socialNetworkService.getPareja(persona));
    }
}
