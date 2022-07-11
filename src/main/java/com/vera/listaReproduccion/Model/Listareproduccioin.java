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
@Table(name = "listareproduccioin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listareproduccioin.findAll", query = "SELECT l FROM Listareproduccioin l"),
    @NamedQuery(name = "Listareproduccioin.findByIdListar", query = "SELECT l FROM Listareproduccioin l WHERE l.idlistar = :idlistar"),
    @NamedQuery(name = "Listareproduccioin.findByDescripcion", query = "SELECT l FROM Listareproduccioin l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Listareproduccioin.findBySongs", query = "SELECT l FROM Listareproduccioin l WHERE l.songs = :songs"),
    @NamedQuery(name = "Listareproduccioin.findByName", query = "SELECT l FROM Listareproduccioin l WHERE l.name = :name")})


public class Listareproduccioin implements Serializable{
    

private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idlistar")
    private Long idLista;
    @Basic(optional = false)
    @Column(name = "songs")
    private String[] songs;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy="idLista")
    private List<Listareproduccioin> listareList;

    public Listareproduccioin() {
    }

    public Listareproduccioin(Long idlista) {
        this.idLista = idlista;
    }

    public Listareproduccioin(Long idlista, String [] songs, String descripcion, String name, List<Listareproduccioin> listareList) {
        this.idLista = idlista;
        this.songs = songs;
        this.descripcion = descripcion;
        this.name = name;
        this.listareList = listareList;
    }

    public Long getIdlista() {
        return idLista;
    }

    public void setIdlista(Long idlista) {
        this.idLista = idlista;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Listareproduccioin> getListareList() {
        return listareList;
    }

    public void setListareList(List<Listareproduccioin> listareList) {
        this.listareList = listareList;
    }

@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Listareproduccioin other = (Listareproduccioin) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

@Override
    public String toString() {
        return "com.vera.listaReproduccion.Model.Listareproduccioin[ idlista=" + idLista + " ]";
    }
}
