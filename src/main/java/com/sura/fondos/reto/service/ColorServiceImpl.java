package com.sura.fondos.reto.service;

import com.sura.fondos.reto.entity.Color;
import com.sura.fondos.reto.entity.ResponseListColor;
import com.sura.fondos.reto.interfaces.ColorService;
import com.sura.fondos.reto.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository colorDao;

    @Override
    public ResponseListColor listarPresentacion() {
        List<Color> lstColor = colorDao.findAll();

        ResponseListColor response = new ResponseListColor();
        List<Color> lstPagina1 = new ArrayList<>();
        List<Color> lstPagina2 = new ArrayList<>();
        List<Color> lstPagina3 = new ArrayList<>();

        int i=0;
        for (Color color: lstColor ) {
            if(i>=0 && i<6){
                lstPagina1.add(color);
            }
            if(i>=6 && i<12){
                lstPagina2.add(color);
            }
            if(i>=12 && i<18){
                lstPagina3.add(color);
            }

            i++;
        }

        response.setPagina1(lstPagina1);
        response.setPagina2(lstPagina2);
        response.setPagina3(lstPagina3);

        return response;
    }

    @Override
    public List<Color> findColors() {
        return colorDao.findAll();
    }

    @Override
    public Color findById(int id) {
        return colorDao.findById(id);
    }

    @Override
    public Color add(Color color) {
        return colorDao.save(color);
    }

    @Override
    public Color edit(Color color) {
        return colorDao.save(color);
    }

    @Override
    public void deleteById(int id) {
         colorDao.deleteById(id);
    }
}
