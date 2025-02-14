package com.utec.group6.reto.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class IngresosMensualesPorEnfermedadId implements Serializable {

    @Column(name = "cancer")
    private String cancer;

    @Column(name = "mes")
    private String mes;

    public IngresosMensualesPorEnfermedadId() {}

    public IngresosMensualesPorEnfermedadId(String cancer, String mes) {
        this.cancer = cancer;
        this.mes = mes;
    }

    public String getCancer() { return cancer; }
    public void setCancer(String cancer) { this.cancer = cancer; }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngresosMensualesPorEnfermedadId that = (IngresosMensualesPorEnfermedadId) o;
        return Objects.equals(cancer, that.cancer) &&
               Objects.equals(mes, that.mes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancer, mes);
    }
}
