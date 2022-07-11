/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vera.listaReproduccion.Service;

import com.vera.listaReproduccion.Model.Listareproduccioin;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ListareproduccionService {
    public Listareproduccioin crear(Listareproduccioin l);

    public Listareproduccioin finById(Long id);

    public List<Listareproduccioin> finByAll();

    public List<Listareproduccioin> finByName(String nom);

    public void delete(Long id);
}
