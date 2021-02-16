package com.sura.fondos.reto.entity;

import javax.persistence.*;

@Entity
@Table(name="rol")
public class Rol {

    @Id
    @Column(name="idrol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column
    private String nombre;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
