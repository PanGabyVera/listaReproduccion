/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vera.listaReproduccion.Service;

import com.vera.listaReproduccion.Model.Cancion;
import com.vera.listaReproduccion.Repository.CancionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pandora
 */
@Service
public class CancionServiceImpl implements CancionService {

   @Autowired 
    private CancionRepository cancionRepository;

    @Override
    public Cancion crear(Cancion c) {
        return cancionRepository.save(c);
    }
//para actualizar

    @Override
    public Cancion finById(Long id) {
        return cancionRepository.findById(id).orElse(null);
    }
//para listardatos

    @Override
    public List<Cancion> finByAll() {
        return cancionRepository.findAll();
    }
//buscar por nombre

    @Override
    public List<Cancion> finByName(String nombre){
        return cancionRepository.buscarNombre(nombre);
    }

    @Override
    public void delete(Long id) {
        cancionRepository.deleteById(id);
    }
}
