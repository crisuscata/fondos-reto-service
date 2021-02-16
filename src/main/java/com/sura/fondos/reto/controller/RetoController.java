package com.sura.fondos.reto.controller;

import com.sura.fondos.reto.entity.*;
import com.sura.fondos.reto.interfaces.ColorService;
import com.sura.fondos.reto.interfaces.UsuarioService;
import com.sura.fondos.reto.util.Constant;
import com.sura.fondos.reto.util.RetoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class RetoController {

    @Autowired
    ColorService colorService;

    @Autowired
    UsuarioService usuarioService;

    Logger logger = LoggerFactory.getLogger(RetoController.class);

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

    @GetMapping("listarPresentacion")
    public ResponseEntity<ApiResponse<ResponseListColor>>  listarPresentacion(){

        ResponseEntity<ApiResponse<ResponseListColor>> responseEntity = null;
        ApiResponse<ResponseListColor> apiResponse = new ApiResponse<>();

        try {
            ResponseListColor lstColor = colorService.listarPresentacion();

            if(lstColor!=null ){
                apiResponse.setDatos(lstColor);
                apiResponse.setResultado(exitosaInvocacion());
            } else{
                apiResponse.setResultado(noExitosaInvocacion());
            }
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } catch (Exception e) {
            apiResponse.setDatos(new ResponseListColor());
            apiResponse.setResultado(noExitosaInvocacion());

            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
            logger.error("Error al invocar metodo listarColor, mensaje: ", e);
        }
        return responseEntity;
    }

    @GetMapping("listarColor")
    public ResponseEntity<ApiResponse<List<Color>>>  listarColor(){

        ResponseEntity<ApiResponse<List<Color>>> responseEntity = null;
        ApiResponse<List<Color>> apiResponse = new ApiResponse<>();

        try {
            List<Color> lstColor = colorService.findColors();

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

    @GetMapping("listarColorId/{id}")
    public ResponseEntity<ApiResponse<Color>> listarColorId(@PathVariable("id") int id){
        ResponseEntity<ApiResponse<Color>> responseEntity = null;
        ApiResponse<Color> apiResponse = new ApiResponse<>();

        try {
            if(id == 0){
                throw  new RetoException(String.valueOf(id));
            }

            Color color = colorService.findById(id);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(getColorResponse(color));
        } catch (Exception e) {
            apiResponse.setDatos(new Color());
            apiResponse.setResultado(noExitosaInvocacion());

            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
            logger.error("Error al invocar metodo listarColorId, mensaje: ", e);
        }
        return responseEntity;
    }

    @PostMapping("agregarColor")
    public ResponseEntity<ApiResponse<Color>> agregarColor(@RequestBody Color p){
        ResponseEntity<ApiResponse<Color>> responseEntity = null;
        ApiResponse<Color> apiResponse = new ApiResponse<>();

        try{
            p.setFechaCreacion(new Date());
            Color color = colorService.add(p);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(getColorResponse(color));
        } catch (Exception e) {
            apiResponse.setDatos(new Color());
            apiResponse.setResultado(noExitosaInvocacion());

            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
            logger.error("Error al invocar metodo agregarColor, mensaje: ", e);
        }
        return responseEntity;
    }

    private ApiResponse<Color> getColorResponse(Color color){
        ApiResponse<Color> apiResponse = new ApiResponse<>();
        if(color!=null &&
                color.getId()!=0){
            apiResponse.setDatos(color);
            apiResponse.setResultado(exitosaInvocacion());
        } else{
            apiResponse.setResultado(noExitosaInvocacion());
        }
        return apiResponse;
    }

    @PutMapping("editarColor/{id}")
    public ResponseEntity<ApiResponse<Color>> editarColor(@RequestBody Color c, @PathVariable("id") int id){
        ResponseEntity<ApiResponse<Color>> responseEntity = null;
        ApiResponse<Color> apiResponse = new ApiResponse<>();

        try{

            if(id == 0){
                throw  new RetoException(String.valueOf(id));
            }

            c.setFechaModificacion(new Date());
            c.setId(id);
            Color color = colorService.edit(c);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(getColorResponse(color));
        } catch (Exception e) {
            apiResponse.setDatos(new Color());
            apiResponse.setResultado(noExitosaInvocacion());

            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
            logger.error("Error al invocar metodo editarColor, mensaje: ", e);
        }

        return responseEntity;
    }

    @DeleteMapping("eliminarColor/{id}")
    public void eliminarColor(@PathVariable("id") int id){
        colorService.deleteById(id);
    }

    @GetMapping("findByUserAndPass/{user}/{pass}")
    public ResponseEntity<ApiResponse<Usuario>> findByUserAndPass(@PathVariable("user") String user,
                                     @PathVariable("pass") String pass){
        ResponseEntity<ApiResponse<Usuario>> responseEntity = null;
        ApiResponse<Usuario> apiResponse = new ApiResponse<>();

        try{

            if(user.equals("0")){
                throw  new RetoException(user);
            }

            Usuario usuario = usuarioService.findByUserAndPass(user, pass);
            if(usuario!=null &&
                    usuario.getIdUsuario()!=0){
                apiResponse.setDatos(usuario);
                apiResponse.setResultado(exitosaInvocacion());
            } else{
                apiResponse.setResultado(noExitosaInvocacion());
            }
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } catch (Exception e) {
            apiResponse.setDatos(new Usuario());
            apiResponse.setResultado(noExitosaInvocacion());

            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
            logger.error("Error al invocar metodo findByUserAndPass, mensaje: ", e);
        }

        return responseEntity;
    }

}
