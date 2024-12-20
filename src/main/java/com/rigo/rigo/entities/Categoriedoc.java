/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
@Table(name = "categoriedoc", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idcatdoc"})})
@NamedQueries({
    @NamedQuery(name = "Categoriedoc.findAll", query = "SELECT c FROM Categoriedoc c"),
    @NamedQuery(name = "Categoriedoc.findByIdcatdoc", query = "SELECT c FROM Categoriedoc c WHERE c.idcatdoc = :idcatdoc"),
    @NamedQuery(name = "Categoriedoc.findByLibcatdoc", query = "SELECT c FROM Categoriedoc c WHERE c.libcatdoc = :libcatdoc")})
public class Categoriedoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcatdoc", nullable = false)
    private Integer idcatdoc;
    @Column(name = "libcatdoc", length = 254)
    private String libcatdoc;
     @JsonIgnore
    @OneToMany(mappedBy = "idcatdoc")
    private Collection<Doctext> doctextCollection;

    public Categoriedoc() {
    }

    public Categoriedoc(Integer idcatdoc) {
        this.idcatdoc = idcatdoc;
    }

    public Integer getIdcatdoc() {
        return idcatdoc;
    }

    public void setIdcatdoc(Integer idcatdoc) {
        this.idcatdoc = idcatdoc;
    }

    public String getLibcatdoc() {
        return libcatdoc;
    }

    public void setLibcatdoc(String libcatdoc) {
        this.libcatdoc = libcatdoc;
    }

    public Collection<Doctext> getDoctextCollection() {
        return doctextCollection;
    }

    public void setDoctextCollection(Collection<Doctext> doctextCollection) {
        this.doctextCollection = doctextCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatdoc != null ? idcatdoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriedoc)) {
            return false;
        }
        Categoriedoc other = (Categoriedoc) object;
        if ((this.idcatdoc == null && other.idcatdoc != null) || (this.idcatdoc != null && !this.idcatdoc.equals(other.idcatdoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Categoriedoc[ idcatdoc=" + idcatdoc + " ]";
    }
    
}
