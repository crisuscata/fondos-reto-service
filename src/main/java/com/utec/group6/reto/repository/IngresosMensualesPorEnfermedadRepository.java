package com.utec.group6.reto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utec.group6.reto.entity.IngresosMensualesPorEnfermedad;
import com.utec.group6.reto.entity.IngresosMensualesPorEnfermedadId;

public interface IngresosMensualesPorEnfermedadRepository extends JpaRepository<IngresosMensualesPorEnfermedad, IngresosMensualesPorEnfermedadId> {
    
    List<IngresosMensualesPorEnfermedad> findAll();
}

