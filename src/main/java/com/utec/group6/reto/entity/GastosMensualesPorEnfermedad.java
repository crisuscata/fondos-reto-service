package com.utec.group6.reto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "gastos_mensuales_por_enfermedad")
public class GastosMensualesPorEnfermedad {

    @EmbeddedId
    private GastosMensualesPorEnfermedadId id;

    @Column(name = "costo")
    private BigDecimal costo;

    public GastosMensualesPorEnfermedadId getId() { return id; }
    public void setId(GastosMensualesPorEnfermedadId id) { this.id = id; }

    public BigDecimal getCosto() { return costo; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
}

