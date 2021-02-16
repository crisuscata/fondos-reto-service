package com.sura.fondos.reto.service;

import com.sura.fondos.reto.entity.Usuario;
import com.sura.fondos.reto.interfaces.UsuarioService;
import com.sura.fondos.reto.repository.UsuarioRepository;
import com.sura.fondos.reto.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioDao;

    @Override
    public Usuario findByUserAndPass(String user, String pass) {
        String passMd5 = Hash.getHash(pass, "MD5");
        return usuarioDao.findByUserAndPass(user, passMd5);
    }
}
