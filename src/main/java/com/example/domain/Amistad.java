package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Amistad {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private Persona persona1;
    @ManyToOne
    private Persona persona2;

    //hibernate (JPA) accede a la base de datos con el constructor vacio y luego con los
    //setters le va añadiendo los atributos

    public Amistad() {
    }
    public Amistad(Persona persona1, Persona persona2) {
        this.persona1 = persona1;
        this.persona2 = persona2;
    }

    public Persona getPersona1() {
        return persona1;
    }
    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public Persona getPersona2() {
        return persona2;
    }
    public void setPersona2(Persona persona2) {
        this.persona2 = persona2;
    }


    @Override
    public String toString() {
        return "Amistad{" +
                "id=" + id +
                ", persona1=" + persona1 +
                ", persona2=" + persona2 +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amistad amistad = (Amistad) o;

        if (!getId().equals(amistad.getId())) return false;
        if (!persona1.equals(amistad.persona1)) return false;
        return persona2.equals(amistad.persona2);

    }
    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + persona1.hashCode();
        result = 31 * result + persona2.hashCode();
        return result;
    }
}
