package com.utec.group6.reto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utec.group6.reto.entity.CostoTratamientoHabitosMalos;
import com.utec.group6.reto.entity.CostoTratamientoHabitosMalosId;

public interface CostoTratamientoHabitosMalosRepository extends JpaRepository<CostoTratamientoHabitosMalos, CostoTratamientoHabitosMalosId> {
    
    List<CostoTratamientoHabitosMalos> findAll();
}