package com.sura.fondos.reto.interfaces;

import com.sura.fondos.reto.entity.Color;
import com.sura.fondos.reto.entity.ResponseListColor;

import java.util.List;

public interface ColorService {
    ResponseListColor listarPresentacion();
    List<Color> findColors();
    Color findById(int id);
    Color add(Color color);
    Color edit(Color color);
    void deleteById(int id);
}
