package com.utec.group6.reto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utec.group6.reto.entity.CostoTratamientoHabitosBuenos;
import com.utec.group6.reto.entity.CostoTratamientoHabitosBuenosId;

public interface CostoTratamientoHabitosBuenosRepository extends JpaRepository<CostoTratamientoHabitosBuenos, CostoTratamientoHabitosBuenosId> {
    
    List<CostoTratamientoHabitosBuenos> findAll();
}

