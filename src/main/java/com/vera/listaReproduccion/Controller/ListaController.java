/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vera.listaReproduccion.Controller;

import com.vera.listaReproduccion.Model.Listareproduccioin;
import com.vera.listaReproduccion.Service.ListareproduccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pandora
 */
@RestController
@RequestMapping("/api/listaR")
public class ListaController {
    
    @Autowired
    ListareproduccionService listaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Listareproduccioin>> listar() {
        return new ResponseEntity<>(listaService.finByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Listareproduccioin> crear(@RequestBody Listareproduccioin c) {
        return new ResponseEntity<>(listaService.crear(c), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{nom}")
    public ResponseEntity<List<Listareproduccioin>> buscar(@PathVariable String nom) {
        return new ResponseEntity<>(listaService.finByName(nom), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Listareproduccioin> eliminar(@PathVariable Long id) {
        listaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Listareproduccioin> actualizar(@PathVariable Long id, @RequestBody Listareproduccioin e) {
        Listareproduccioin ca = buscarId(id);

        if (ca == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ca.setDescripcion(e.getDescripcion());
                ca.setName(e.getName());
                ca.setSongs(e.getSongs());

                return new ResponseEntity<>(listaService.crear(e), HttpStatus.OK);

            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
public Listareproduccioin buscarId( Long id){
     return listaService.finById(id);
}
}
