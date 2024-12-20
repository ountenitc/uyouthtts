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
@Table(name = "langue", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idlangue_"})})
@NamedQueries({
    @NamedQuery(name = "Langue.findAll", query = "SELECT l FROM Langue l"),
    @NamedQuery(name = "Langue.findByIdlangue", query = "SELECT l FROM Langue l WHERE l.idlangue = :idlangue"),
    @NamedQuery(name = "Langue.findByLiblangue", query = "SELECT l FROM Langue l WHERE l.liblangue = :liblangue"),
    @NamedQuery(name = "Langue.findByAppelationethnie", query = "SELECT l FROM Langue l WHERE l.appelationethnie = :appelationethnie"),
    @NamedQuery(name = "Langue.findByPayslangue", query = "SELECT l FROM Langue l WHERE l.payslangue = :payslangue"),
    @NamedQuery(name = "Langue.findByRegionlangue", query = "SELECT l FROM Langue l WHERE l.regionlangue = :regionlangue"),
    @NamedQuery(name = "Langue.findByNombrelocuteur", query = "SELECT l FROM Langue l WHERE l.nombrelocuteur = :nombrelocuteur")})
public class Langue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlangue_", nullable = false)
    private Integer idlangue;
    @Column(name = "liblangue", length = 254)
    private String liblangue;
    @Column(name = "appelationethnie", length = 254)
    private String appelationethnie;
    @Column(name = "payslangue", length = 254)
    private String payslangue;
    @Column(name = "regionlangue", length = 254)
    private String regionlangue;
    @Column(name = "nombrelocuteur", length = 254)
    private String nombrelocuteur;
     @JsonIgnore
    @OneToMany(mappedBy = "idlangue")
    private Collection<Motexpressionmr> motexpressionmrCollection;

    public Langue() {
    }

    public Langue(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public Integer getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public String getLiblangue() {
        return liblangue;
    }

    public void setLiblangue(String liblangue) {
        this.liblangue = liblangue;
    }

    public String getAppelationethnie() {
        return appelationethnie;
    }

    public void setAppelationethnie(String appelationethnie) {
        this.appelationethnie = appelationethnie;
    }

    public String getPayslangue() {
        return payslangue;
    }

    public void setPayslangue(String payslangue) {
        this.payslangue = payslangue;
    }

    public String getRegionlangue() {
        return regionlangue;
    }

    public void setRegionlangue(String regionlangue) {
        this.regionlangue = regionlangue;
    }

    public String getNombrelocuteur() {
        return nombrelocuteur;
    }

    public void setNombrelocuteur(String nombrelocuteur) {
        this.nombrelocuteur = nombrelocuteur;
    }

    public Collection<Motexpressionmr> getMotexpressionmrCollection() {
        return motexpressionmrCollection;
    }

    public void setMotexpressionmrCollection(Collection<Motexpressionmr> motexpressionmrCollection) {
        this.motexpressionmrCollection = motexpressionmrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlangue != null ? idlangue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langue)) {
            return false;
        }
        Langue other = (Langue) object;
        if ((this.idlangue == null && other.idlangue != null) || (this.idlangue != null && !this.idlangue.equals(other.idlangue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Langue[ idlangue=" + idlangue + " ]";
    }
    
}
