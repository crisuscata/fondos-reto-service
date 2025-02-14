package com.utec.group6.reto.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class CostoTratamientoHabitosBuenosId implements Serializable {

    @Column(name = "tipo_cancer")
    private String tipoCancer;

    public CostoTratamientoHabitosBuenosId() {}

    public CostoTratamientoHabitosBuenosId(String tipoCancer) {
        this.tipoCancer = tipoCancer;
    }

    public String getTipoCancer() { return tipoCancer; }
    public void setTipoCancer(String tipoCancer) { this.tipoCancer = tipoCancer; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostoTratamientoHabitosBuenosId that = (CostoTratamientoHabitosBuenosId) o;
        return Objects.equals(tipoCancer, that.tipoCancer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoCancer);
    }
}
