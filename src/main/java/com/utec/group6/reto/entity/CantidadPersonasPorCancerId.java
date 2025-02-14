package com.utec.group6.reto.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class CantidadPersonasPorCancerId implements Serializable {

    @Column(name = "cantidad_pacientes")
    private Long cantidadPacientes;

    @Column(name = "tipo_cancer")
    private String tipoCancer;

    // Default constructor
    public CantidadPersonasPorCancerId() {}

    // Constructor with parameters
    public CantidadPersonasPorCancerId(Long cantidadPacientes, String tipoCancer) {
        this.cantidadPacientes = cantidadPacientes;
        this.tipoCancer = tipoCancer;
    }

    // Getters and Setters
    public Long getCantidadPacientes() { return cantidadPacientes; }
    public void setCantidadPacientes(Long cantidadPacientes) { this.cantidadPacientes = cantidadPacientes; }

    public String getTipoCancer() { return tipoCancer; }
    public void setTipoCancer(String tipoCancer) { this.tipoCancer = tipoCancer; }

    // Equals and hashCode for composite key comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CantidadPersonasPorCancerId that = (CantidadPersonasPorCancerId) o;
        return Objects.equals(cantidadPacientes, that.cantidadPacientes) &&
               Objects.equals(tipoCancer, that.tipoCancer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidadPacientes, tipoCancer);
    }
}
