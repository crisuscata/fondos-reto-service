package com.utec.group6.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utec.group6.reto.entity.Diagnostico;
import com.utec.group6.reto.interfaces.DiagnosticoService;
import com.utec.group6.reto.repository.DiagnosticoRepository;

@Service
public class DiagnosticoImpl implements DiagnosticoService {
	
	@Autowired
	DiagnosticoRepository dao;

	@Override
	public List<Diagnostico> findAll() {
		return dao.findAll();
	}

	@Override
	public Diagnostico findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

}
