/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vera.listaReproduccion.Repository;

import com.vera.listaReproduccion.Model.Listareproduccioin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LENOVO
 */
public interface ListareproduccionRepository extends JpaRepository<Listareproduccioin, Long>{
@Query(value="SELECT * FROM listareproduccioin c WHERE c.name = :nombre",nativeQuery = true)
    public List<Listareproduccioin> buscarNombre(String nombre);
    
}
