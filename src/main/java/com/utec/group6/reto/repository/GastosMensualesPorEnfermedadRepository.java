package com.utec.group6.reto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utec.group6.reto.entity.GastosMensualesPorEnfermedad;
import com.utec.group6.reto.entity.GastosMensualesPorEnfermedadId;

public interface GastosMensualesPorEnfermedadRepository extends JpaRepository<GastosMensualesPorEnfermedad, GastosMensualesPorEnfermedadId > {
    
    List<GastosMensualesPorEnfermedad> findAll();
}

