/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vera.listaReproduccion.Controller;

import com.vera.listaReproduccion.Model.Cancion;
import com.vera.listaReproduccion.Service.CancionService;
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
@RequestMapping("/api/cancion")
public class CancionController {

    @Autowired
    CancionService cancionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Cancion>> listar() {
        return new ResponseEntity<>(cancionService.finByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cancion> crear(@RequestBody Cancion c) {
        return new ResponseEntity<>(cancionService.crear(c), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{nom}")
    public ResponseEntity<List<Cancion>> buscar(@PathVariable String nom) {
        return new ResponseEntity<>(cancionService.finByName(nom), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cancion> eliminar(@PathVariable Long id) {
        cancionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cancion> actualizar(@PathVariable Long id, @RequestBody Cancion e) {
        Cancion ca = buscarId(id);

        if (ca == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ca.setAlbum(e.getAlbum());
                ca.setArtist(e.getArtist());
                ca.setTitle(e.getTitle());
                ca.setYear(e.getYear());

                return new ResponseEntity<>(cancionService.crear(e), HttpStatus.OK);

            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
public Cancion buscarId( Long id){
     return cancionService.finById(id);
}

}
