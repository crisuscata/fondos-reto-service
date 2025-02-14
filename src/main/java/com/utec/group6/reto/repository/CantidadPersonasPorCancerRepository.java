package com.utec.group6.reto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utec.group6.reto.entity.CantidadPersonasPorCancer;
import com.utec.group6.reto.entity.CantidadPersonasPorCancerId;

public interface CantidadPersonasPorCancerRepository extends JpaRepository<CantidadPersonasPorCancer, CantidadPersonasPorCancerId> {
    
    List<CantidadPersonasPorCancer> findAll();
}

