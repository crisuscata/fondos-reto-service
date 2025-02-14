package com.utec.group6.reto.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utec.group6.reto.entity.ApiResponse;
import com.utec.group6.reto.entity.GastosMensualesPorEnfermedad;
import com.utec.group6.reto.entity.Respuesta;
import com.utec.group6.reto.interfaces.GastosMensualesPorEnfermedadService;
import com.utec.group6.reto.util.Constant;

@RestController
@CrossOrigin
public class GastosMensualesPorEnfermedadController {

    @Autowired
    private GastosMensualesPorEnfermedadService service;

    Logger logger = LoggerFactory.getLogger(GastosMensualesPorEnfermedadController.class);

    @GetMapping("listarGastos")
    public ResponseEntity<ApiResponse<List<GastosMensualesPorEnfermedad>>> listarGastos() {
        ApiResponse<List<GastosMensualesPorEnfermedad>> apiResponse = new ApiResponse<>();
        try {
            List<GastosMensualesPorEnfermedad> data = service.findAll();
            apiResponse.setDatos(data);
            apiResponse.setResultado(new Respuesta(Constant.CODIGO_EXITOSO, Constant.MENSAJE_EXITOSO));
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.error("Error en listarGastos", e);
            apiResponse.setDatos(new ArrayList<>());
            apiResponse.setResultado(new Respuesta(Constant.CODIGO_ERROR_NO_ENCONTRADO, Constant.MENSAJE_NO_ENCONTRADO));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }
}
