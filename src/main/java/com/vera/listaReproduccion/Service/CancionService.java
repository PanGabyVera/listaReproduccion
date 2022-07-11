/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vera.listaReproduccion.Service;

import com.vera.listaReproduccion.Model.Cancion;
import java.util.List;

/**
 *
 * @author Pandora
 */
public interface CancionService {

    public Cancion crear(Cancion c);

    public Cancion finById(Long id);

    public List<Cancion> finByAll();

    public List<Cancion> finByName(String nom);

    public void delete(Long id);
}
