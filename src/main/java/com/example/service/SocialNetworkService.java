package com.example.service;

import com.example.domain.Amistad;
import com.example.domain.Pareja;
import com.example.domain.Persona;
import com.example.repository.AmistadRepository;
import com.example.repository.ParejaRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //este tiene que ser

import java.util.*;

@Service
@Transactional
public class SocialNetworkService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;
    @Autowired
    private AmistadRepository amistadRepository;

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

    public List<Persona> getAmistades(Persona persona){
        List<Amistad>amistades=amistadRepository.getAmistades(persona);
        List<Persona> resultado=new ArrayList<>();

        for (Amistad amistad:amistades){
            if (amistad.getPersona1().equals(persona)){
                resultado.add(amistad.getPersona2());
            }else if (amistad.getPersona2().equals(persona)){
                resultado.add(amistad.getPersona1());
            }
        }
        return resultado;
    }

    public Amistad addAmistades(Persona persona1,Persona persona2){
        return amistadRepository.
                save(new Amistad(persona1,persona2));
    }

    public List<Persona> getConectionPath (Persona personaInicio, Persona personaDestino){

            Persona primeroLista=personaInicio;

            Set<Persona> visitado = new HashSet<>();
            Map<Persona, Persona> predecesor = new HashMap<>();

            List camino = new LinkedList();
            Queue<Persona> cola = new LinkedList();

            cola.add(primeroLista);
            visitado.add(primeroLista);

            while(!cola.isEmpty()){
                primeroLista = cola.poll();
                System.out.println("Voy a visitar la persona: ");
                System.out.println(primeroLista);
                if (primeroLista.equals(personaDestino)){
                    break;
                }else{
                    for(Persona amigo : getAmistades(primeroLista)){
                        if(!visitado.contains(amigo)){
                            cola.add(amigo);
                            visitado.add(amigo);
                            predecesor.put(amigo, primeroLista);
                        }
                    }
                }
            }

            for(Persona persona = personaDestino;
                persona != null;
                persona = predecesor.get(persona)) {

                camino.add(persona);
            }

            Collections.reverse(camino);

            System.out.println("Muestro el camino mínimo entre Oscar y Ariadna");
            System.out.println(camino);

            return camino;
        }
    }

