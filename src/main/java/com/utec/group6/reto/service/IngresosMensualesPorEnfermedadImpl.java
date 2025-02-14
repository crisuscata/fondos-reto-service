package com.utec.group6.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utec.group6.reto.entity.IngresosMensualesPorEnfermedad;
import com.utec.group6.reto.interfaces.IngresosMensualesPorEnfermedadService;
import com.utec.group6.reto.repository.IngresosMensualesPorEnfermedadRepository;

@Service
public class IngresosMensualesPorEnfermedadImpl implements IngresosMensualesPorEnfermedadService {
    
    @Autowired
    private IngresosMensualesPorEnfermedadRepository repository;

    @Override
    public List<IngresosMensualesPorEnfermedad> findAll() {
        return repository.findAll();
    }
}

