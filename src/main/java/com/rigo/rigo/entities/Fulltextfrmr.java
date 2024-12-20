/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
@Table(name = "fulltextfrmr", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idstoriefrmr"})})
@NamedQueries({
    @NamedQuery(name = "Fulltextfrmr.findAll", query = "SELECT f FROM Fulltextfrmr f"),
    @NamedQuery(name = "Fulltextfrmr.findByIdstoriefrmr", query = "SELECT f FROM Fulltextfrmr f WHERE f.idstoriefrmr = :idstoriefrmr"),
    @NamedQuery(name = "Fulltextfrmr.findBySttextefr", query = "SELECT f FROM Fulltextfrmr f WHERE f.sttextefr = :sttextefr"),
    @NamedQuery(name = "Fulltextfrmr.findBySttextemr", query = "SELECT f FROM Fulltextfrmr f WHERE f.sttextemr = :sttextemr"),
    @NamedQuery(name = "Fulltextfrmr.findByStaudiomr", query = "SELECT f FROM Fulltextfrmr f WHERE f.staudiomr = :staudiomr")})
public class Fulltextfrmr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstoriefrmr", nullable = false)
    private Integer idstoriefrmr;
    @Column(name = "sttextefr", length = 2147483647)
    private String sttextefr;
    @Column(name = "langue", length = 2147483647)
    private String langue;
    @Column(name = "sttextemr", length = 2147483647)
    private String sttextemr;
    @Column(name = "staudiomr", length = 254)
    private String staudiomr;
    @JoinColumn(name = "iddoctext", referencedColumnName = "iddoctext")
    @ManyToOne
    private Doctext iddoctext;

    public Fulltextfrmr() {
    }

    public Fulltextfrmr(Integer idstoriefrmr) {
        this.idstoriefrmr = idstoriefrmr;
    }

    public Integer getIdstoriefrmr() {
        return idstoriefrmr;
    }

    public void setIdstoriefrmr(Integer idstoriefrmr) {
        this.idstoriefrmr = idstoriefrmr;
    }

    public String getSttextefr() {
        return sttextefr;
    }

    public void setSttextefr(String sttextefr) {
        this.sttextefr = sttextefr;
    }

    public String getSttextemr() {
        return sttextemr;
    }

    public void setSttextemr(String sttextemr) {
        this.sttextemr = sttextemr;
    }

    public String getStaudiomr() {
        return staudiomr;
    }

    public void setStaudiomr(String staudiomr) {
        this.staudiomr = staudiomr;
    }

    public Doctext getIddoctext() {
        return iddoctext;
    }

    public void setIddoctext(Doctext iddoctext) {
        this.iddoctext = iddoctext;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstoriefrmr != null ? idstoriefrmr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fulltextfrmr)) {
            return false;
        }
        Fulltextfrmr other = (Fulltextfrmr) object;
        if ((this.idstoriefrmr == null && other.idstoriefrmr != null) || (this.idstoriefrmr != null && !this.idstoriefrmr.equals(other.idstoriefrmr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Fulltextfrmr[ idstoriefrmr=" + idstoriefrmr + " ]";
    }
    
}
