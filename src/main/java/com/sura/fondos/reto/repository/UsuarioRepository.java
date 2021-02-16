package com.sura.fondos.reto.repository;

import com.sura.fondos.reto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario u where u.usuario = ?1 and u.password= ?2  ")
    Usuario findByUserAndPass(String user, String pass);

}
