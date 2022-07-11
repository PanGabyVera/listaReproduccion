/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vera.listaReproduccion.Repository;

import com.vera.listaReproduccion.Model.Cancion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pandora
 */
public interface CancionRepository extends JpaRepository<Cancion, Long>{
    @Query(value="SELECT * FROM cancion c WHERE c.name = :nombre",nativeQuery = true)
    public List<Cancion> buscarNombre(String nombre);
}
