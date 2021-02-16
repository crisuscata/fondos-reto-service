package com.sura.fondos.reto.service;

import com.sura.fondos.reto.entity.Color;
import com.sura.fondos.reto.entity.ResponseListColor;
import com.sura.fondos.reto.entity.Usuario;
import com.sura.fondos.reto.repository.ColorRepository;
import com.sura.fondos.reto.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ColorServiceImplTest {

    @InjectMocks
    ColorServiceImpl colorServiceImpl;

    @Mock
    ColorRepository colorDao;

    @InjectMocks
    UsuarioServiceImpl usuarioServiceImpl;

    @Mock
    UsuarioRepository usuarioDao;


    @Test
    public void retorna_findAllConInformacion2() {

        List<Color> lstColor = new ArrayList<>();

        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);
        lstColor.add(color);

        color.setId(2);
        color.setColor("#DECDBE");
        color.setName("Sand Soles");
        color.setPantone("14-1106");
        color.setYear(2022);
        lstColor.add(color);

        when(this.colorDao.findAll()).thenReturn(lstColor);
        ResponseListColor lstColorResponse = colorServiceImpl.listarPresentacion();
        assertNotNull(lstColorResponse);
    }

    @Test
    public void retorna_findByIdConInformacion2() {

        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);

        when(this.colorDao.findById(Mockito.anyInt())).thenReturn(color);
        Color colorResponse = colorServiceImpl.findById(1);
        assertNotNull(colorResponse);
    }

    @Test
    public void retorna_addConInformacion2() {

        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);

        when(this.colorDao.save( ArgumentMatchers.any()  )).thenReturn(color);
        Color colorResponse = colorServiceImpl.add(color);
        assertNotNull(colorResponse);
    }

    @Test
    public void retorna_editConInformacion2() {

        Color color = new Color();
        color.setId(1);
        color.setColor("#DECDBE");
        color.setName("Sand Dollar");
        color.setPantone("13-1106");
        color.setYear(2021);

        when(this.colorDao.save( ArgumentMatchers.any()  )).thenReturn(color);
        Color colorResponse = colorServiceImpl.edit(color);
        assertNotNull(colorResponse);
    }

    @Test
    public void retorna_deleteByIdConInformacion2() {
        this.colorDao.deleteById(1);
        colorServiceImpl.deleteById(1);
    }

    @Test
    public void retorna_findByUserAndPassConInformacion2() {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("Admin");
        usuario.setApellidos("Apellidos");
        usuario.setUsuario("Admin");
        usuario.setPassword("WSCXCS");

        when(this.usuarioDao.findByUserAndPass(Mockito.anyString(), Mockito.anyString())).thenReturn(usuario);
        Usuario usuarioResponse = usuarioServiceImpl.findByUserAndPass("admin", "admin");
        assertNotNull(usuarioResponse);
    }

}
