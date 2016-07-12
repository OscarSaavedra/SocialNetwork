package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String marca;
    private String modelo;
    private Long matricula;
    private Integer precio;
    private Integer añoFabricacion;

    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getAñoFabricacion() {
        return añoFabricacion;
    }
    public void setAñoFabricacion(Integer añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula=" + matricula +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", Id=" + Id +
                ", precio=" + precio +
                ", añoFabricacion=" + añoFabricacion +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche coche = (Coche) o;

        if (getMatricula() != null ? !getMatricula().equals(coche.getMatricula()) : coche.getMatricula() != null)
            return false;
        if (getMarca() != null ? !getMarca().equals(coche.getMarca()) : coche.getMarca() != null) return false;
        if (getModelo() != null ? !getModelo().equals(coche.getModelo()) : coche.getModelo() != null) return false;
        if (getId() != null ? !getId().equals(coche.getId()) : coche.getId() != null) return false;
        if (getPrecio() != null ? !getPrecio().equals(coche.getPrecio()) : coche.getPrecio() != null) return false;
        return getAñoFabricacion() != null ? getAñoFabricacion().equals(coche.getAñoFabricacion()) : coche.getAñoFabricacion() == null;

    }
    @Override
    public int hashCode() {
        int result = getMatricula() != null ? getMatricula().hashCode() : 0;
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getPrecio() != null ? getPrecio().hashCode() : 0);
        result = 31 * result + (getAñoFabricacion() != null ? getAñoFabricacion().hashCode() : 0);
        return result;
    }
}
