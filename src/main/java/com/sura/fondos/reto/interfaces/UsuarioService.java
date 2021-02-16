package com.sura.fondos.reto.interfaces;

import com.sura.fondos.reto.entity.Usuario;

public interface UsuarioService {

    Usuario findByUserAndPass(String user, String pass);

}
