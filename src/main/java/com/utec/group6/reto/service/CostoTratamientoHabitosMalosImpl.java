package com.utec.group6.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utec.group6.reto.entity.CostoTratamientoHabitosMalos;
import com.utec.group6.reto.interfaces.CostoTratamientoHabitosMalosService;
import com.utec.group6.reto.repository.CostoTratamientoHabitosMalosRepository;

@Service
public class CostoTratamientoHabitosMalosImpl implements CostoTratamientoHabitosMalosService {
    
    @Autowired
    private CostoTratamientoHabitosMalosRepository repository;

    @Override
    public List<CostoTratamientoHabitosMalos> findAll() {
        return repository.findAll();
    }
}

