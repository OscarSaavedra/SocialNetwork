package com.example;

import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication2 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);

        testSocialNetwork(socialNetworkService);
    }

    private static void testSocialNetwork(SocialNetworkService socialNetworkService){
        //Inicio bloque creación de personas y asignación de conexiones 2
        Persona ricard=new Persona();
        ricard.setNombre("Ricard");
        ricard.setAge(20);
        socialNetworkService.addPerson(ricard);

        Persona manuel=new Persona();
        manuel.setNombre("Manuel");
        manuel.setAge(15);
        socialNetworkService.addPerson(manuel);

        Persona sara=new Persona();
        sara.setNombre("Sara");
        sara.setAge(50);
        socialNetworkService.addPerson(sara);

        Persona aroa=new Persona();
        aroa.setNombre("Aroa");
        aroa.setAge(34);
        socialNetworkService.addPerson(aroa);

        Persona david=new Persona();
        david.setNombre("David");
        david.setAge(19);
        socialNetworkService.addPerson(david);

        Persona ismael=new Persona();
        ismael.setNombre("Ismael");
        ismael.setAge(31);
        socialNetworkService.addPerson(ismael);

        Persona javier=new Persona();
        javier.setNombre("Javier");
        javier.setAge(38);
        socialNetworkService.addPerson(javier);

        Persona alex=new Persona();
        alex.setNombre("Alex");
        alex.setAge(14);
        socialNetworkService.addPerson(alex);

        socialNetworkService.addAmistades(ricard,manuel);
        socialNetworkService.addAmistades(ricard,sara);
        socialNetworkService.addAmistades(sara,manuel);
        socialNetworkService.addAmistades(manuel,aroa);
        socialNetworkService.addAmistades(sara,aroa);
        socialNetworkService.addAmistades(aroa,david);
        socialNetworkService.addAmistades(david,aroa);
        socialNetworkService.addAmistades(aroa,javier);
        socialNetworkService.addAmistades(david,ismael);
        socialNetworkService.addAmistades(ismael,javier);
        socialNetworkService.addAmistades(ismael,alex);
        socialNetworkService.addAmistades(aroa,javier);
        //Final bloque creación de personas y asignación de conexiones 2

        List<Persona> caminoMinimo2= socialNetworkService.getConectionPath(ricard,javier);

        System.out.println("Están conectados a una distancia de : ["+(caminoMinimo2.size()-1)+"]");
    }
}
