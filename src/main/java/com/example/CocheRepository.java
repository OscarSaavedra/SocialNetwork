package com.example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; //importante que no sea otro que spring

import java.util.List;

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
    @Query("SELECT AVG (coche.precio)from Coche coche where coche.marca=:marca")
    Double obtenerMediaPorMarca(@Param("marca ")String marca);
    //en lugar de coche podria poner c

}
