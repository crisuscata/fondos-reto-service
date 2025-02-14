package com.utec.group6.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utec.group6.reto.entity.CantidadPersonasPorCancer;
import com.utec.group6.reto.interfaces.CantidadPersonasPorCancerService;
import com.utec.group6.reto.repository.CantidadPersonasPorCancerRepository;

@Service
public class CantidadPersonasPorCancerImpl implements CantidadPersonasPorCancerService {
    
    @Autowired
    private CantidadPersonasPorCancerRepository repository;

    @Override
    public List<CantidadPersonasPorCancer> findAll() {
        return repository.findAll();
    }
}