/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vera.listaReproduccion.Service;

import com.vera.listaReproduccion.Model.Listareproduccioin;
import com.vera.listaReproduccion.Repository.ListareproduccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class ListrareproduccionServiceImpl implements ListareproduccionService{
    
   @Autowired 
    private ListareproduccionRepository listaRepository;

    @Override
    public Listareproduccioin crear(Listareproduccioin l) {
        return listaRepository.save(l);
    }
//para actualizar

    @Override
    public Listareproduccioin finById(Long id) {
        return listaRepository.findById(id).orElse(null);
    }
//para listardatos

    @Override
    public List<Listareproduccioin> finByAll() {
        return listaRepository.findAll();
    }
//buscar por nombre

    @Override
    public List<Listareproduccioin> finByName(String nombre){
        return listaRepository.buscarNombre(nombre);
    }

    @Override
    public void delete(Long id) {
        listaRepository.deleteById(id);
    }
}
