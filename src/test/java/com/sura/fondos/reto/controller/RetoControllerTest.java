package com.sura.fondos.reto.controller;

import com.sura.fondos.reto.entity.Color;
import com.sura.fondos.reto.entity.ResponseListColor;
import com.sura.fondos.reto.entity.Usuario;
import com.sura.fondos.reto.interfaces.ColorService;
import com.sura.fondos.reto.interfaces.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RetoControllerTest {

    @InjectMocks
    RetoController retoController;

    @Mock
    ColorService colorService;

    @Mock
    UsuarioService usuarioService;


    @Test
    public void executeIntegration_listarPresentacion() {
        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);

        List<Color> lstColor = new ArrayList<>();
        lstColor.add(color);

        ResponseListColor responseListColor =new ResponseListColor();
        responseListColor.setPagina1(lstColor);
        responseListColor.setPagina2(lstColor);
        responseListColor.setPagina3(lstColor);
        Mockito.when(colorService.listarPresentacion()).thenReturn(responseListColor);

        retoController.listarPresentacion();
    }

    @Test
    public void executeIntegration_listarPresentacion2() {
        ResponseListColor responseListColor =new ResponseListColor();
        Mockito.when(colorService.listarPresentacion()).thenReturn(responseListColor);
        retoController.listarPresentacion();
    }

    @Test
    public void executeIntegration_listarColorId() {
        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);
        Mockito.when(colorService.findById(Mockito.anyInt())).thenReturn(color);
        retoController.listarColorId(1);
    }

    @Test
    public void executeIntegration_listarColorId2_error() {
        Color color = new Color();
        color.setId(0);
        Mockito.lenient().when(colorService.findById(Mockito.anyInt())).thenReturn(color);
        retoController.listarColorId(0);
    }

    @Test
    public void executeIntegration_agregarColor() {
        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);
        Mockito.when(colorService.add( ArgumentMatchers.any() )).thenReturn(color);
        retoController.agregarColor(color);
    }

    @Test
    public void executeIntegration_agregarColor_error() {
        Color color = new Color();
        color.setFechaCreacion(null);
        Mockito.when(colorService.add( ArgumentMatchers.any() )).thenReturn(color);
        retoController.agregarColor(color);
    }

    @Test
    public void executeIntegration_editarColor() {
        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);
        Mockito.when(colorService.edit( ArgumentMatchers.any() )).thenReturn(color);
        retoController.editarColor(color, 1);
    }

    @Test
    public void executeIntegration_editarColor_error() {
        Color color = new Color();
        color.setId(0);
        Mockito.lenient().when(colorService.edit( ArgumentMatchers.any() )).thenReturn(color);
        retoController.editarColor(color, 0);
    }

    @Test
    public void executeIntegration_eliminarColor() {
        retoController.eliminarColor(1);
    }

    @Test
    public void executeIntegration_findByUserAndPass() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("Admin");
        usuario.setApellidos("Apellidos");
        usuario.setUsuario("Admin");
        usuario.setPassword("WSCXCS");
        Mockito.when(usuarioService.findByUserAndPass( Mockito.anyString(), Mockito.anyString() )).thenReturn(usuario);
        retoController.findByUserAndPass("admin", "admin");
    }

    @Test
    public void executeIntegration_findByUserAndPass2() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        Mockito.when(usuarioService.findByUserAndPass( Mockito.anyString(), Mockito.anyString() )).thenReturn(usuario);
        retoController.findByUserAndPass("admin", "admin");
    }

    @Test
    public void executeIntegration_findByUserAndPass3() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        Mockito.lenient().when(usuarioService.findByUserAndPass( Mockito.anyString(), Mockito.anyString() )).thenReturn(usuario);
        retoController.findByUserAndPass("0", "admin");
    }

}
