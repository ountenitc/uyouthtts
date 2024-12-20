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
@Table(name = "motexpressionfr", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idmefr"})})
@NamedQueries({
    @NamedQuery(name = "Motexpressionfr.findAll", query = "SELECT m FROM Motexpressionfr m"),
    @NamedQuery(name = "Motexpressionfr.findByIdmefr", query = "SELECT m FROM Motexpressionfr m WHERE m.idmefr = :idmefr"),
    @NamedQuery(name = "Motexpressionfr.findByFormeecrite", query = "SELECT m FROM Motexpressionfr m WHERE m.formeecrite = :formeecrite"),
    @NamedQuery(name = "Motexpressionfr.findByFormprononce", query = "SELECT m FROM Motexpressionfr m WHERE m.formprononce = :formprononce")})
public class Motexpressionfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmefr", nullable = false)
    private Integer idmefr;
    @Column(name = "formeecrite", length = 254)
    private String formeecrite;
    @Column(name = "formprononce", length = 254)
    private String formprononce;
    @JoinColumn(name = "idalph", referencedColumnName = "idalph")
    @ManyToOne
    private Alphabetfr idalph;
     @JsonIgnore
    @OneToMany(mappedBy = "idmefr")
    private Collection<Motexpressionmr> motexpressionmrCollection;

    public Motexpressionfr() {
    }

    public Motexpressionfr(Integer idmefr) {
        this.idmefr = idmefr;
    }

    public Integer getIdmefr() {
        return idmefr;
    }

    public void setIdmefr(Integer idmefr) {
        this.idmefr = idmefr;
    }

    public String getFormeecrite() {
        return formeecrite;
    }

    public void setFormeecrite(String formeecrite) {
        this.formeecrite = formeecrite;
    }

    public String getFormprononce() {
        return formprononce;
    }

    public void setFormprononce(String formprononce) {
        this.formprononce = formprononce;
    }

    public Alphabetfr getIdalph() {
        return idalph;
    }

    public void setIdalph(Alphabetfr idalph) {
        this.idalph = idalph;
    }

    @XmlTransient
    public Collection<Motexpressionmr> getMotexpressionmrCollection() {
        return motexpressionmrCollection;
    }

    public void setMotexpressionmrCollection(Collection<Motexpressionmr> motexpressionmrCollection) {
        this.motexpressionmrCollection = motexpressionmrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmefr != null ? idmefr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motexpressionfr)) {
            return false;
        }
        Motexpressionfr other = (Motexpressionfr) object;
        if ((this.idmefr == null && other.idmefr != null) || (this.idmefr != null && !this.idmefr.equals(other.idmefr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Motexpressionfr[ idmefr=" + idmefr + " ]";
    }
    
}
