package com.example.repository;

import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Persona findByNombre(String nombre); //lo hemos simplificado para que no de una lista (irreal)
    List<Persona> findByNombreAndApellido(String nombre, String apellido);
    List<Persona> findByNombreOrApellido(String nombre, String apellido);

    List<Persona> findByAgeGreaterThanEqual(Integer age);
    List<Persona> findByAgeLessThanEqual(Integer age);

    //List<Persona>findParejas(Persona pareja1,Persona pareja2);//hay que añadir esto para que funcione
    // el pareja repository
}
