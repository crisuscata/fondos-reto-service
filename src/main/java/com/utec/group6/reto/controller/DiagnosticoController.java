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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.utec.group6.reto.entity.ApiResponse;
import com.utec.group6.reto.entity.Diagnostico;
import com.utec.group6.reto.entity.Respuesta;
import com.utec.group6.reto.interfaces.DiagnosticoService;
import com.utec.group6.reto.util.Constant;
import com.utec.group6.reto.util.RetoException;

@RestController
@CrossOrigin
public class DiagnosticoController {
	
	@Autowired
	DiagnosticoService diagnosticoService;
	
	 Logger logger = LoggerFactory.getLogger(DiagnosticoController.class);

	    private Respuesta exitosaInvocacion(){
	        Respuesta respuesta = new Respuesta();
	        respuesta.setCodigo(Constant.CODIGO_EXITOSO);
	        respuesta.setDescripcion(Constant.MENSAJE_EXITOSO);
	        return respuesta;
	    }

	    private Respuesta noExitosaInvocacion(){
	        Respuesta respuesta = new Respuesta();
	        respuesta.setCodigo(Constant.CODIGO_ERROR_NO_ENCONTRADO);
	        respuesta.setDescripcion(Constant.MENSAJE_NO_ENCONTRADO);
	        return respuesta;
	    }
	    
	    @GetMapping("listarDiagnostico")
	    public ResponseEntity<ApiResponse<List<Diagnostico>>>  listarDiagnostico(){

	        ResponseEntity<ApiResponse<List<Diagnostico>>> responseEntity = null;
	        ApiResponse<List<Diagnostico>> apiResponse = new ApiResponse<>();

	        try {
	            List<Diagnostico> lstColor = diagnosticoService.findAll();

	            if(lstColor!=null ){
	                apiResponse.setDatos(lstColor);
	                apiResponse.setResultado(exitosaInvocacion());
	            } else{
	                apiResponse.setResultado(noExitosaInvocacion());
	            }
	            responseEntity = ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	        } catch (Exception e) {
	            apiResponse.setDatos(new ArrayList<>());
	            apiResponse.setResultado(noExitosaInvocacion());

	            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
	            logger.error("Error al invocar metodo listarColor, mensaje: ", e);
	        }
	        return responseEntity;
	    }
	    
	    private ApiResponse<Diagnostico> getDiagnosticoResponse(Diagnostico color){
	        ApiResponse<Diagnostico> apiResponse = new ApiResponse<>();
	        if(color!=null &&
	                color.getIdDiagnostico()!=0){
	            apiResponse.setDatos(color);
	            apiResponse.setResultado(exitosaInvocacion());
	        } else{
	            apiResponse.setResultado(noExitosaInvocacion());
	        }
	        return apiResponse;
	    }
	    
	    
	    @GetMapping("listarDiagnostico/{id}")
	    public ResponseEntity<ApiResponse<Diagnostico>> listarDiagnosticoId(@PathVariable("id") int id){
	        ResponseEntity<ApiResponse<Diagnostico>> responseEntity = null;
	        ApiResponse<Diagnostico> apiResponse = new ApiResponse<>();

	        try {
	            if(id == 0){
	                throw  new RetoException(String.valueOf(id));
	            }

	            Diagnostico color = diagnosticoService.findById(id);
	            responseEntity = ResponseEntity.status(HttpStatus.OK).body(getDiagnosticoResponse(color));
	        } catch (Exception e) {
	            apiResponse.setDatos(new Diagnostico());
	            apiResponse.setResultado(noExitosaInvocacion());

	            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
	            logger.error("Error al invocar metodo listarColorId, mensaje: ", e);
	        }
	        return responseEntity;
	    }
	    

}
