package com.utec.group6.reto.interfaces;

import java.util.List;

import com.utec.group6.reto.entity.Diagnostico;

public interface DiagnosticoService {
	
	List<Diagnostico> findAll();
	
	Diagnostico findById(Integer id);

}
