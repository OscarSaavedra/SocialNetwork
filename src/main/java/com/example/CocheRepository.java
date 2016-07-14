package com.example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; //importante que no sea otro que spring

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CocheRepository extends JpaRepository<Coche,Long>{

    List<Coche>findByModelo(String modelo);
    List<Coche>findByPrecio(String precio);
    List<Coche>findByAñoFabricacion(int añoFabricacion);
    List<Coche>findByAñoFabricacionLessThanEqual(int añoFabricacion);
    List<Coche>findByAñoFabricacionGreaterThanEqual(int añoFabricacion);

    List<Coche>findByPrecioLessThanEqual(int precio);
    List<Coche>findByPrecioGreaterThanEqual(int precio);

    Coche findByMatricula(Long matricula);
    List<Coche>findByMarca(String marca);
    List<Coche>findByMarcaOrModelo(String marca,String modelo);
    List<Coche>findByPrecioBetween(Integer precio, Integer precio2);
    List<Coche>findByMarcaAndPrecioLessThanEqual(String marca,Integer precio);
    List<Coche>findByMarcaAndPrecioGreaterThanEqual(String marca,Integer precio);
    List<Coche>findByMarcaAndPrecioGreaterThanEqualAndModelo(String marca,Integer precio,String modelo);

    //para crear consultas como las anteriores, pero a mano
    @Query("SELECT AVG (c.precio)from Coche c where c.marca=:marca")
    Double obtenerMediaPorMarca(@Param("marca")String marca);

    @Query ("SELECT(coche)from Coche coche where coche.propietario=:propietario")
    List<Coche>obtenerCoches(@Param("propietario")Persona propietario);//importante repasar

    @Query("SELECT (coche)from Coche coche where coche.propietario=:propietario AND coche.precio>=:precio")//importante poner 2 puntos
    List<Coche>obtenerCochesAndPrecioGreaterThanEqual(@Param("propietario")Persona propietario,@Param("precio")Integer precio);

    @Query("SELECT (coche)from Coche coche where coche.propietario=:propietario AND coche.añoFabricacion between :año1 and :año2")
    List<Coche>obtenerCochesEntreAños(@Param("propietario")Persona propietario,@Param("año1")Integer año1,@Param("año2")Integer año2);

    @Query("SELECT (coche)from Coche coche where coche.propietario.age>=:edad")
    List<Coche>obtenerCochesEdadMasGrandeOIgual(@Param("edad")Integer edad);

    @Query("SELECT (coche)from Coche coche where coche.propietario.age between :edad1 and :edad2")
    List<Coche>obtenerCochesEdadEntre(@Param("edad1")Integer edad1,@Param("edad2")Integer edad2);



    //@Query ("SELECT (ch)from Coche ch where ch.matricula like(concat('%',:fragmentoMatricula,'%'))")
    //List<Coche> getCocheMatriculasQueContengan(@Param ("fragmentoMatricula") String fragmentoMatricula);//IMPORTANTE
    //Todos los coches cuya matricula contenga una sub-string

    @Query("SELECT coche.marca ,AVG (coche.precio), MAX (coche.precio), MIN (coche.precio) from Coche coche group by coche.marca")
    List<Object[]>findByCocheArimeticaAndPrecioMaxIs(); //selecciona la marca, el precio medio, el max, el min de Coche
    //y lo agrupa por marca


    //que agrupe por año y para cada año diga cuantos se han fabricado
    @Query("SELECT coche.añoFabricacion,count (coche) from Coche as coche group by coche.añoFabricacion")
    List<Object[]>cuantosCochesPorAño();//IMPORTANTE
}
