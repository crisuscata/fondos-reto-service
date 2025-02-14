package com.utec.group6.reto.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "costo_tratamiento_habitos_malos")
public class CostoTratamientoHabitosMalos {

    @EmbeddedId
    private CostoTratamientoHabitosMalosId id;

    @Column(name = "costo_total")
    private BigDecimal costoTotal;

    public CostoTratamientoHabitosMalosId getId() { return id; }
    public void setId(CostoTratamientoHabitosMalosId id) { this.id = id; }

    public BigDecimal getCostoTotal() { return costoTotal; }
    public void setCostoTotal(BigDecimal costoTotal) { this.costoTotal = costoTotal; }
}


