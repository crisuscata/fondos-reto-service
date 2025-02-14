package com.utec.group6.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utec.group6.reto.entity.GastosMensualesPorEnfermedad;
import com.utec.group6.reto.interfaces.GastosMensualesPorEnfermedadService;
import com.utec.group6.reto.repository.GastosMensualesPorEnfermedadRepository;

@Service
public class GastosMensualesPorEnfermedadImpl implements GastosMensualesPorEnfermedadService {
    
    @Autowired
    private GastosMensualesPorEnfermedadRepository repository;

    @Override
    public List<GastosMensualesPorEnfermedad> findAll() {
        return repository.findAll();
    }
}