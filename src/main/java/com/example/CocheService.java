package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;
    @Autowired//autoconectar
    private PersonaRepository personaRepository;

    public void testCoche(){
        Coche coche1=new Coche();
        coche1.setMarca("Ferrari");
        coche1.setAñoFabricacion(1990);
        coche1.setModelo("Turbo");
        coche1.setPrecio(200000);
        coche1.setMatricula(2452745L);


        Persona persona10 = new Persona();
        persona10.setNombre("Pedro");
        persona10.setAge(23);
        coche1.setPropietario(persona10);
        personaRepository.save(persona10);//primero se guarda la persona
        cocheRepository.save(coche1);//luego se guarda el coche. IMPORTANTE


        Coche coche2=new Coche();
        coche2.setMarca("Renault");
        coche2.setAñoFabricacion(1990);
        coche2.setModelo("Familiar");
        coche2.setPrecio(50000);
        coche2.setMatricula(9867245L);

        Persona ivan=personaRepository.getOne(1L);
        coche2.setPropietario(ivan);
        cocheRepository.save(coche2);


        Coche coche3=new Coche();
        coche3.setMarca("BMW");
        coche3.setAñoFabricacion(2010);
        coche3.setModelo("i5");
        coche3.setPrecio(100000);
        coche3.setMatricula(7864245L);
        cocheRepository.save(coche3);

        Coche coche4=new Coche();
        coche4.setMarca("Audi");
        coche4.setAñoFabricacion(2005);
        coche4.setModelo("a8");
        coche4.setPrecio(75000);
        coche4.setMatricula(3156245L);
        cocheRepository.save(coche4);

        Coche coche5=new Coche();
        coche5.setMarca("Renault");
        coche5.setAñoFabricacion(2005);
        coche5.setModelo("Diesel");
        coche5.setPrecio(70000);
        coche5.setMatricula(4134245L);
        coche5.setPropietario(ivan);
        cocheRepository.save(coche5);

        Coche coche6=new Coche();
        coche6.setMarca("Volkswagen");
        coche6.setAñoFabricacion(2015);
        coche6.setModelo("Voyager");
        coche6.setPrecio(25000);
        coche6.setMatricula(95342445L);
        cocheRepository.save(coche6);

        Coche coche7=new Coche();
        coche7.setMarca("Renault");
        coche7.setAñoFabricacion(2012);
        coche7.setModelo("Express");
        coche7.setPrecio(40000);
        coche7.setMatricula(15242745L);
        cocheRepository.save(coche7);

        Coche coche8=new Coche();
        coche8.setMarca("Ferrari");
        coche8.setAñoFabricacion(2015);
        coche8.setModelo("Accesible");
        coche8.setPrecio(50000);
        coche8.setMatricula(24342355L);
        cocheRepository.save(coche8);


        Coche coche9=new Coche();
        coche9.setMarca("Volkswagen");
        coche9.setAñoFabricacion(2015);
        coche9.setModelo("Voyager");
        coche9.setPrecio(75000);
        coche9.setMatricula(954563235L);
        cocheRepository.save(coche9);

        Coche coche10=new Coche();
        coche10.setMarca("Volkswagen");
        coche10.setAñoFabricacion(2015);
        coche10.setModelo("Voyager");
        coche10.setPrecio(100000);
        coche10.setMatricula(14353445L);
        cocheRepository.save(coche10);

        Coche coche11=new Coche();
        coche11.setMarca("Renault");
        coche11.setAñoFabricacion(20015);
        coche11.setModelo("Deluxe");
        coche11.setPrecio(250000);
        coche11.setMatricula(2537647L);
        coche11.setPropietario(ivan);
        cocheRepository.save(coche11);

        System.out.println("Coches con año de fabricación menor o igual a 2000");
        System.out.println(cocheRepository.findByAñoFabricacionLessThanEqual(2000));

        System.out.println("Coches con año de fabricación mayor o igual a 2000");
        System.out.println(cocheRepository.findByAñoFabricacionGreaterThanEqual(2000));


        System.out.println("Coches con un precio menor o igual a 75.000");
        System.out.println(cocheRepository.findByPrecioLessThanEqual(75000));

        System.out.println("Coches con un precio mayor o igual a 75.000");
        System.out.println(cocheRepository.findByPrecioGreaterThanEqual(75000));

        System.out.println("Coches en que se encuentran entre 50000 y 100000");
        System.out.println(cocheRepository.findByPrecioBetween(50000,100000));


        System.out.println("Coche con matrícula: 95342445L");
        System.out.println(cocheRepository.findByMatricula(95342445L));


        System.out.println("Coches de la marca: Audi");
        System.out.println(cocheRepository.findByMarca("Audi"));

        System.out.println("Coches de marca BMW o de modelo Voyager");
        System.out.println(cocheRepository.findByMarcaOrModelo("BMW","Voyager"));


        System.out.println("Coches de la marca Ferrari cuyo precio sea igual o menor a 100.000");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Ferrari",100000));

        System.out.println("Coches de la marca Renault cuyo precio sea igual o mayor a 50.000");
        System.out.println(cocheRepository.findByMarcaAndPrecioGreaterThanEqual("Renault",50000));

        System.out.println("Coches de la marca Volkswagen del modelo Voyager con un precio superior o igual a 50.000");
        System.out.println(cocheRepository.findByMarcaAndPrecioGreaterThanEqualAndModelo("Volkswagen",50000,"Voyager"));


        System.out.println("La media de precio de todos los Volkswagen");
        System.out.println(cocheRepository.obtenerMediaPorMarca("Volkswagen"));

        System.out.println("Muestra todos los coches que tiene Ivan");
        System.out.println(cocheRepository.obtenerCoches(ivan));

        System.out.println("Muestra todos los coches que tiene Ivan y que superen los 200.000 euros");
        System.out.println(cocheRepository.obtenerCochesAndPrecioGreaterThanEqual(ivan,200000));

        System.out.println("Muestra todos los coches que tiene Ivan cuyo año de fabricación se situa entre 2000 y 2015");
        System.out.println(cocheRepository.obtenerCochesEntreAños(ivan,2000,2015));

        System.out.println("Mostrar todos los coches de las personas con mas de 23 años");
        System.out.println(cocheRepository.obtenerCochesEdadMasGrandeOIgual(23));

        System.out.println("Mostrar todos los coches de personas entre 20 y 24 años");
        System.out.println(cocheRepository.obtenerCochesEdadEntre(20,24));

        System.out.println("java 5");

        List<Object[]> estadisticasMarcaList =cocheRepository.findByCocheArimeticaAndPrecioMaxIs();

        for (Object[] estadisticasMarca : estadisticasMarcaList) {
            System.out.println("marca: " + estadisticasMarca[0]);
            System.out.println("media: " + estadisticasMarca[1]);
            System.out.println("max: " + estadisticasMarca[2]);
            System.out.println("min: " + estadisticasMarca[3]);
            System.out.println("------------------------------------------------------------------");
        }//forma de realizarlo con java5


        System.out.println("/////////////////////////////////////");

        for (Object[] porAños:cocheRepository.cuantosCochesPorAño()){
            Integer año=(Integer)porAños[0];
            System.out.println("Año de fabricación: "+año);
            System.out.println("Cantidad coches: "+porAños[1]);
            System.out.println("Listado de coches por año: "+cocheRepository.findByAñoFabricacion(año));
        }//repasar
    }
}
