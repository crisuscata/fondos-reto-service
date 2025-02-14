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
import com.utec.group6.reto.entity.CantidadPersonasPorCancer;
import com.utec.group6.reto.entity.Respuesta;
import com.utec.group6.reto.interfaces.CantidadPersonasPorCancerService;
import com.utec.group6.reto.util.Constant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "CantidadPersonasPorCancer", description = "Endpoints for managing CantidadPersonasPorCancer")
public class CantidadPersonasPorCancerController {

    @Autowired
    private CantidadPersonasPorCancerService service;

    Logger logger = LoggerFactory.getLogger(CantidadPersonasPorCancerController.class);

    @GetMapping("listarCantidadPersonas")
    @Operation(summary = "Get all CantidadPersonasPorCancer", description = "Fetches all CantidadPersonasPorCancer records from the database")
    public ResponseEntity<ApiResponse<List<CantidadPersonasPorCancer>>> listarCantidadPersonas() {
        ApiResponse<List<CantidadPersonasPorCancer>> apiResponse = new ApiResponse<>();
        try {
            List<CantidadPersonasPorCancer> data = service.findAll();
            apiResponse.setDatos(data);
            apiResponse.setResultado(new Respuesta(Constant.CODIGO_EXITOSO, Constant.MENSAJE_EXITOSO));
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.error("Error en listarCantidadPersonas", e);
            apiResponse.setDatos(new ArrayList<>());
            apiResponse.setResultado(new Respuesta(Constant.CODIGO_ERROR_NO_ENCONTRADO, Constant.MENSAJE_NO_ENCONTRADO));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }
}
