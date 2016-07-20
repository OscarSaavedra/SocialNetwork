package com.example;

import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication3 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);

        testSocialNetwork(socialNetworkService);
    }

    private static void testSocialNetwork(SocialNetworkService socialNetworkService){

        //Inicio bloque creación de personas y asignación de conexiones 3
        Persona marcos=new Persona();
        marcos.setNombre("Marcos");
        marcos.setAge(23);
        socialNetworkService.addPerson(marcos);

        Persona oriol=new Persona();
        oriol.setNombre("Oriol");
        oriol.setAge(28);
        socialNetworkService.addPerson(oriol);

        Persona daniel=new Persona();
        daniel.setNombre("Daniel");
        daniel.setAge(23);
        socialNetworkService.addPerson(daniel);


        Persona dimple=new Persona();
        dimple.setNombre("Dimple");
        dimple.setAge(24);
        socialNetworkService.addPerson(dimple);

        Persona diana=new Persona();
        diana.setNombre("Diana");
        diana.setAge(32);
        socialNetworkService.addPerson(diana);

        Persona alfredo=new Persona();
        alfredo.setNombre("Alfredo");
        alfredo.setAge(30);
        socialNetworkService.addPerson(alfredo);


        socialNetworkService.addAmistades(marcos,oriol);
        socialNetworkService.addAmistades(marcos,daniel);
        socialNetworkService.addAmistades(marcos,dimple);

        socialNetworkService.addAmistades(dimple,diana);
        socialNetworkService.addAmistades(diana,alfredo);
        //Final bloque creación de personas y asignación de conexiones 3


        //Inicio bloque creación de personas y asignación de conexiones aisladas
        Persona ruben=new Persona();
        ruben.setNombre("Ruben");
        ruben.setAge(23);
        socialNetworkService.addPerson(ruben);

        Persona noelia=new Persona();
        noelia.setNombre("Noelia");
        noelia.setAge(24);
        socialNetworkService.addPerson(noelia);

        socialNetworkService.addAmistades(ruben,noelia);
        //Final bloque creación de personas y asignación de conexiones aisladas


        System.out.println("Intentamos llegar de Marcos a Ruben");
        System.out.println(socialNetworkService.getConectionPath(marcos,ruben));
    }
}
