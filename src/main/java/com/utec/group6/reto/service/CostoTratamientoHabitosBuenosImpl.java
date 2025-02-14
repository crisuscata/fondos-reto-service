package com.utec.group6.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utec.group6.reto.entity.CostoTratamientoHabitosBuenos;
import com.utec.group6.reto.interfaces.CostoTratamientoHabitosBuenosService;
import com.utec.group6.reto.repository.CostoTratamientoHabitosBuenosRepository;

@Service
public class CostoTratamientoHabitosBuenosImpl implements CostoTratamientoHabitosBuenosService {
    
    @Autowired
    private CostoTratamientoHabitosBuenosRepository repository;

    @Override
    public List<CostoTratamientoHabitosBuenos> findAll() {
        return repository.findAll();
    }
}

