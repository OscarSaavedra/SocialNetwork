package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //este tiene que ser

@Service
@Transactional
public class SocialNetworkService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;

    public void addPerson(Persona persona){
        personaRepository.save(persona);

    }
    public void addPareja (Persona persona, Persona persona2){
        Pareja pareja =new Pareja(persona,persona2);
        parejaRepository.save(pareja);
    }

    public Persona getPersona(Long id){
        return personaRepository.findOne(id);
    }
    public Persona getPersona(String nombre){
        return personaRepository.findByNombre(nombre);

    }

    public Persona getPareja(Persona persona){
        Pareja pareja=parejaRepository.getPareja(persona);
        Persona resultado=null;

        if(pareja==null){
            return null;
        }
        else
        {
            if (pareja.getP1().equals(persona))
                {
                resultado=pareja.getP2();
                }
            else if (pareja.getP2().equals(persona))
                {
                resultado=pareja.getP1();
                }
            return resultado;
        }
    }

    /*public void testSocialNetwork(){
        Persona ivan=personaRepository.getOne(1L);
        Persona dimple=personaRepository.getOne(2L);
        addPareja(ivan,dimple);

        System.out.println(parejaRepository);
    }*/
}
