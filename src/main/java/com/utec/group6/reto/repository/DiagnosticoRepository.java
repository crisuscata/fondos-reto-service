package com.utec.group6.reto.repository;

import java.awt.Color;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.utec.group6.reto.entity.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

    List<Diagnostico> findAll();


}
