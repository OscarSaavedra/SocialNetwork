package com.example;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public void testPersonas(){
        Persona persona = new Persona();
        persona.setNombre("Ivan");
        persona.setAge(23);
        personaRepository.save(persona);

        Persona persona2 = new Persona();
        persona2.setNombre("Dimple");
        persona2.setAge(21);
        personaRepository.save(persona2);

        Persona persona3 =new Persona();
        persona3.setNombre("Noelia");
        persona3.setAge(26);
        persona3.setApellido("VIlla");
        personaRepository.save(persona3);

        Persona persona4=new Persona();
        persona4.setNombre("Jordi");
        persona4.setAge(20);
        personaRepository.save(persona4);

        Persona persona5=new Persona();
        persona5.setNombre("Ricard");
        persona5.setAge(25);
        personaRepository.save(persona5);

        Persona persona6=new Persona();
        persona6.setNombre("Noelia");
        persona6.setApellido("Hernandez");
        persona6.setAge(25);
        personaRepository.save(persona6);






        //crear entidad coche: tendrá ID, marca, modelo, año de fabricacion,
        //el precio y la matricula.
        //Hacer consultas de: coches cuyo año de fabricación
        //sea igual o mayor a un año determinado y alreves, luego entre un rango de años.
        //Lo mismo pero con los precios.
        //Consultar por matrícula, si es de uno solo, devolver objeto y no lista.
        //Consultar todos los coches de una determinada marca.
        //Consultar todos los coches de una marca y modelo.


        //Consultar todos los coches de una determinada marca y que el precio sea inferior o igual
        //a un valor.
        //Consultar todos los coches que sean de una marca y un modelo concreto y que además tengan
        //un precio igual o superior.
        //Consultar el precio medio de todos los coches de una determinada marca. CHUNGO (groupBy).





        System.out.println(personaRepository.findOne(2L));
        System.out.println(personaRepository.findByNombre("Noelia"));
        System.out.println(personaRepository.findByNombre("Ricard"));

        System.out.println("Mostramos todas las personas cuya edad es >=22:");
        System.out.println(personaRepository.findByAgeGreaterThanEqual(20));


        System.out.println("Personas con menos de 25 años: ");
        System.out.println(personaRepository.findByAgeLessThanEqual(25));

        System.out.println("Mostramos personas que se llamen Noelia Villa");
        System.out.println(personaRepository.findByNombreAndApellido("Noelia","Villa"));

        System.out.println("Mostramos personas que se llamen Noelia o el apellido sea Villa");
        System.out.println(personaRepository.findByNombreOrApellido("Noelia","Villa"));

        System.out.println("Grupo");

    }
}
