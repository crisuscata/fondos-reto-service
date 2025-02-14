package com.utec.group6.reto.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ingresos_mensuales_por_enfermedad")
public class IngresosMensualesPorEnfermedad {

    @EmbeddedId
    private IngresosMensualesPorEnfermedadId id;

    @Column(name = "ingreso")
    private BigDecimal ingreso;
}
