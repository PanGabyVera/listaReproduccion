/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vera.listaReproduccion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.finByAll", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.findByIdCancion", query = "SELECT c FROM Cancion c WHERE c.idcancion = :idcancion"),
    @NamedQuery(name = "Cancion.findByArtist", query = "SELECT c FROM Cancion c WHERE c.artist = :artist"),
    @NamedQuery(name = "Cancion.findByAlbum", query = "SELECT c FROM Cancion c WHERE c.album = :album"),
    @NamedQuery(name = "Cancion.findByYear", query = "SELECT c FROM Cancion c WHERE c.year = :year"),
    @NamedQuery(name = "Cancion.findByTitle", query = "SELECT c FROM Cancion c WHERE c.title = :title")})

public class Cancion implements Serializable{
    
 private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcancion")
    private Long idCancion;
    @Basic(optional = false)
    @Column(name = "artist")
    private String artist;
    @Basic(optional = false)
    @Column(name = "album")
    private String album;
    @Basic(optional = false)
    @Column(name = "year")
    private Long year;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy="idCancion")
    private List<Cancion> cancionList;

    public Cancion() {
    }

    public Cancion(Long idcancion) {
        this.idCancion = idcancion;
    }


    public Cancion(Long idcancion, String artist, String album, Long year, String title, List<Cancion> cancionList) {
        this.idCancion = idcancion;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.title = title;
        this.cancionList = cancionList;
    }

    public Long getIdcancion() {
        return idCancion;
    }

    public void setIdcancion(Long idcancion) {
        this.idCancion = idcancion;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Cancion> getCancionList() {
        return cancionList;
    }

    public void setCancionList(List<Cancion> cancionList) {
        this.cancionList = cancionList;
    }

@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idCancion == null && other.idCancion != null) || (this.idCancion != null && !this.idCancion.equals(other.idCancion))) {
            return false;
        }
        return true;
    }

@Override
    public String toString() {
        return "com.vera.listaReproduccion.Model.Cancion[ idCancion=" + idCancion + " ]";
    }

}
