package com.sura.fondos.reto.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="color")
public class Color {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private String pantone;

    @Column
    private int year;

    @Column(name="fechamodificacion")
    private Date fechaModificacion;

    @Column(name="fechacreacion")
    private Date fechaCreacion;

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantone() {
        return pantone;
    }

    public void setPantone(String pantone) {
        this.pantone = pantone;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
