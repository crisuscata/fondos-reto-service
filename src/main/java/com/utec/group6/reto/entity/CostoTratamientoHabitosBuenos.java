package com.utec.group6.reto.entity;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "costo_tratamiento_habitos_buenos")
public class CostoTratamientoHabitosBuenos {

    @EmbeddedId
    private CostoTratamientoHabitosBuenosId id;

    @Column(name = "costo_total")
    private BigDecimal costoTotal;

    public CostoTratamientoHabitosBuenosId getId() { return id; }
    public void setId(CostoTratamientoHabitosBuenosId id) { this.id = id; }

    public BigDecimal getCostoTotal() { return costoTotal; }
    public void setCostoTotal(BigDecimal costoTotal) { this.costoTotal = costoTotal; }
}

