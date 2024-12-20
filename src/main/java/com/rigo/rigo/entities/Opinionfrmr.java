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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
@Table(name = "opinionfrmr", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idopinionfrmr"})})
@NamedQueries({
    @NamedQuery(name = "Opinionfrmr.findAll", query = "SELECT o FROM Opinionfrmr o"),
    @NamedQuery(name = "Opinionfrmr.findByIdopinionfrmr", query = "SELECT o FROM Opinionfrmr o WHERE o.idopinionfrmr = :idopinionfrmr"),
    @NamedQuery(name = "Opinionfrmr.findByOptextefr", query = "SELECT o FROM Opinionfrmr o WHERE o.optextefr = :optextefr"),
    @NamedQuery(name = "Opinionfrmr.findByOptextemr", query = "SELECT o FROM Opinionfrmr o WHERE o.optextemr = :optextemr"),
    @NamedQuery(name = "Opinionfrmr.findByOpaudiomr", query = "SELECT o FROM Opinionfrmr o WHERE o.opaudiomr = :opaudiomr")})
public class Opinionfrmr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idopinionfrmr", nullable = false)
    private Integer idopinionfrmr;
    @Column(name = "optextefr", length = 2147483647)
    private String optextefr;
    @Column(name = "optextemr", length = 2147483647)
    private String optextemr;
    @Column(name = "opaudiomr", length = 254)
    private String opaudiomr;
    @JoinColumn(name = "iddoctext", referencedColumnName = "iddoctext")
    @ManyToOne
    private Doctext iddoctext;
     @JsonIgnore
     @OneToMany(mappedBy = "idopinionfrmr")
    private Collection<Reponseopinionfrmr> reponseopinionfrmrCollection;

    public Opinionfrmr() {
    }

    public Opinionfrmr(Integer idopinionfrmr) {
        this.idopinionfrmr = idopinionfrmr;
    }

    public Integer getIdopinionfrmr() {
        return idopinionfrmr;
    }

    public void setIdopinionfrmr(Integer idopinionfrmr) {
        this.idopinionfrmr = idopinionfrmr;
    }

    public String getOptextefr() {
        return optextefr;
    }

    public void setOptextefr(String optextefr) {
        this.optextefr = optextefr;
    }

    public String getOptextemr() {
        return optextemr;
    }

    public void setOptextemr(String optextemr) {
        this.optextemr = optextemr;
    }

    public String getOpaudiomr() {
        return opaudiomr;
    }

    public void setOpaudiomr(String opaudiomr) {
        this.opaudiomr = opaudiomr;
    }

    public Doctext getIddoctext() {
        return iddoctext;
    }

    public void setIddoctext(Doctext iddoctext) {
        this.iddoctext = iddoctext;
    }
    
    @XmlTransient
    public Collection<Reponseopinionfrmr> getReponseopinionfrmrCollection() {
        return reponseopinionfrmrCollection;
    }

    public void setReponseopinionfrmrCollection(Collection<Reponseopinionfrmr> reponseopinionfrmrCollection) {
        this.reponseopinionfrmrCollection = reponseopinionfrmrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopinionfrmr != null ? idopinionfrmr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opinionfrmr)) {
            return false;
        }
        Opinionfrmr other = (Opinionfrmr) object;
        if ((this.idopinionfrmr == null && other.idopinionfrmr != null) || (this.idopinionfrmr != null && !this.idopinionfrmr.equals(other.idopinionfrmr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Opinionfrmr[ idopinionfrmr=" + idopinionfrmr + " ]";
    }
    
}
