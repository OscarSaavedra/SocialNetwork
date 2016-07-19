package com.example;

import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(DemoApplication.class, args);

        SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);

        testSocialNetwork(socialNetworkService);
    }

    private static void testSocialNetwork(SocialNetworkService socialNetworkService) {

        //Inicio bloque creación de personas y asignación de conexiones 1
        Persona ismael =new Persona();
        ismael.setNombre("Ismael");
        ismael.setAge(25);
        Persona judith= new Persona();
        judith.setNombre("Judith");
        judith.setAge(24);
        socialNetworkService.addPerson(ismael);
        socialNetworkService.addPerson(judith);

        Persona oscar =new Persona();
        oscar.setNombre("Oscar");
        oscar.setAge(24);
        socialNetworkService.addPerson(oscar);

        Persona laura =new Persona();
        laura.setNombre("Laura");
        laura.setAge(21);
        socialNetworkService.addPerson(laura);

        Persona carlos =new Persona();
        carlos.setNombre("Carlos");
        carlos.setAge(19);
        socialNetworkService.addPerson(carlos);

        Persona jorge =new Persona();
        jorge.setNombre("Jorge");
        jorge.setAge(30);
        socialNetworkService.addPerson(jorge);

        Persona mireya =new Persona();
        mireya.setNombre("Mireya");
        mireya.setAge(18);
        socialNetworkService.addPerson(mireya);

        Persona roberto =new Persona();
        roberto.setNombre("Roberto");
        roberto.setAge(20);
        socialNetworkService.addPerson(roberto);

        Persona paco =new Persona();
        paco.setNombre("Paco");
        paco.setAge(32);
        socialNetworkService.addPerson(paco);

        Persona ariadna =new Persona();
        ariadna.setNombre("Ariadna");
        ariadna.setAge(24);
        socialNetworkService.addPerson(ariadna);

        socialNetworkService.addAmistades(oscar,jorge);
        socialNetworkService.addAmistades(oscar,carlos);
        socialNetworkService.addAmistades(oscar,laura);

        socialNetworkService.addAmistades(jorge,mireya);
        socialNetworkService.addAmistades(mireya,roberto);
        socialNetworkService.addAmistades(roberto,paco);
        socialNetworkService.addAmistades(paco,ariadna);

        socialNetworkService.addAmistades(laura,ariadna);
        //Final bloque creación de personas y asignación de conexiones 1


        List<Persona> caminoMinimo=socialNetworkService.getConectionPath(oscar,ariadna);

        System.out.println("Están conectados a una distancia de: ["+(caminoMinimo.size()-1)+"]");
        System.out.println("////////////////////////////////////////////////////////////");


        Persona novia=new Persona();
        socialNetworkService.addPerson(novia);

        Persona ivan = new Persona();
        ivan.setNombre("Ivan");
        ivan.setAge(23);
        socialNetworkService.addPerson(ivan);

        Persona dimple = new Persona();
        dimple.setNombre("Dimple");
        dimple.setAge(21);
        socialNetworkService.addPerson(dimple);

        socialNetworkService.addPareja(ivan,dimple);
        System.out.println("La pareja de Ivan");
        System.out.println(socialNetworkService.getPareja(ivan));
        socialNetworkService.addAmistades(ivan, ismael);
        socialNetworkService.addAmistades(judith,ivan);

        System.out.println("Los amigos de ivan son:");
        System.out.println(socialNetworkService.getAmistades(ivan));

        System.out.println("Los amigos de judith son:");
        System.out.println(socialNetworkService.getAmistades(judith));
    }
}
