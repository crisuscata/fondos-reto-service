package com.sura.fondos.reto.repository;

import com.sura.fondos.reto.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    List<Color> findAll();

    Color save(Color color);

    @Modifying
    @Query(value = "delete from Color c where c.id = ?1")
    void deleteById(int id);

    @Query(value = "select * from color where id = ?1", nativeQuery = true)
    Color findById(int id);

}
