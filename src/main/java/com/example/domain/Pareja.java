package com.example.domain;

import javax.persistence.*;

@Entity
public class Pareja {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    private Persona p1;
    @OneToOne
    private Persona p2;


    public Pareja() {
    }
    public Pareja(Persona p1, Persona p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Persona getP1() {
        return p1;
    }
    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    public Persona getP2() {
        return p2;
    }
    public void setP2(Persona p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Pareja{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pareja pareja = (Pareja) o;

        if (!getId().equals(pareja.getId())) return false;
        if (!getP1().equals(pareja.getP1())) return false;
        return getP2().equals(pareja.getP2());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getP1().hashCode();
        result = 31 * result + getP2().hashCode();
        return result;
    }
}
