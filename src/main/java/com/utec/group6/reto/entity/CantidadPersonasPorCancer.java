package com.utec.group6.reto.entity;

import javax.persistence.*;

@Entity
@Table(name = "cantidad_personas_por_cancer")
public class CantidadPersonasPorCancer {

    @EmbeddedId
    private CantidadPersonasPorCancerId id;

    // Getters and Setters
    public CantidadPersonasPorCancerId getId() { return id; }
    public void setId(CantidadPersonasPorCancerId id) { this.id = id; }
}

