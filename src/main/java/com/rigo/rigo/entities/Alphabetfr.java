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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;
/**
 *
 * @author HP
 */
@Entity
@XmlRootElement
@Data
@Table(name = "alphabetfr", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idalph"})})
@NamedQueries({
    @NamedQuery(name = "Alphabetfr.findAll", query = "SELECT a FROM Alphabetfr a"),
    @NamedQuery(name = "Alphabetfr.findByIdalph", query = "SELECT a FROM Alphabetfr a WHERE a.idalph = :idalph"),
    @NamedQuery(name = "Alphabetfr.findByLettre", query = "SELECT a FROM Alphabetfr a WHERE a.lettre = :lettre"),
    @NamedQuery(name = "Alphabetfr.findByPhonetalph", query = "SELECT a FROM Alphabetfr a WHERE a.phonetalph = :phonetalph")})
public class Alphabetfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalph", nullable = false)
    private Integer idalph;
    @Column(name = "lettre")
    private Character lettre;
    @Column(name = "phonetalph", length = 254)
    private String phonetalph;
     @JsonIgnore
    @OneToMany(mappedBy = "idalph")
    private Collection<Motexpressionfr> motexpressionfrCollection;

    public Alphabetfr() {
    }

    public Alphabetfr(Integer idalph) {
        this.idalph = idalph;
    }

    public Integer getIdalph() {
        return idalph;
    }

    public void setIdalph(Integer idalph) {
        this.idalph = idalph;
    }

    public Character getLettre() {
        return lettre;
    }

    public void setLettre(Character lettre) {
        this.lettre = lettre;
    }

    public String getPhonetalph() {
        return phonetalph;
    }

    public void setPhonetalph(String phonetalph) {
        this.phonetalph = phonetalph;
    }

    @XmlTransient
    public Collection<Motexpressionfr> getMotexpressionfrCollection() {
        return motexpressionfrCollection;
    }

    
    public void setMotexpressionfrCollection(Collection<Motexpressionfr> motexpressionfrCollection) {
        this.motexpressionfrCollection = motexpressionfrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalph != null ? idalph.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alphabetfr)) {
            return false;
        }
        Alphabetfr other = (Alphabetfr) object;
        if ((this.idalph == null && other.idalph != null) || (this.idalph != null && !this.idalph.equals(other.idalph))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Alphabetfr[ idalph=" + idalph + " ]";
    }
    
}
