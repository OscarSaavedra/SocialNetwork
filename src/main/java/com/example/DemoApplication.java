package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(DemoApplication.class, args);

		//PersonaService personaService=context.getBean(PersonaService.class);
		//personaService.testPersonas();

		//CocheService cocheService=context.getBean(CocheService.class);
		//cocheService.testCoche();

		SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);

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
