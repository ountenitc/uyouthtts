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
@Table(name = "motexpressionmr", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idmemr"})})
@NamedQueries({
    @NamedQuery(name = "Motexpressionmr.findAll", query = "SELECT m FROM Motexpressionmr m"),
    @NamedQuery(name = "Motexpressionmr.findByIdmemr", query = "SELECT m FROM Motexpressionmr m WHERE m.idmemr = :idmemr"),
    @NamedQuery(name = "Motexpressionmr.findByFormecritmr", query = "SELECT m FROM Motexpressionmr m WHERE m.formecritmr = :formecritmr"),
    @NamedQuery(name = "Motexpressionmr.findByFormprononcemr", query = "SELECT m FROM Motexpressionmr m WHERE m.formprononcemr = :formprononcemr")})
public class Motexpressionmr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmemr", nullable = false)
    private Integer idmemr;
    @Column(name = "formecritmr", length = 254)
    private String formecritmr;
    @Column(name = "formprononcemr", length = 254)
    private String formprononcemr;
    @JoinColumn(name = "idlangue_", referencedColumnName = "idlangue_")
    @ManyToOne
    private Langue idlangue;
    @JoinColumn(name = "idmefr", referencedColumnName = "idmefr")
    @ManyToOne
    private Motexpressionfr idmefr;

    public Motexpressionmr() {
    }

    public Motexpressionmr(Integer idmemr) {
        this.idmemr = idmemr;
    }

    public Integer getIdmemr() {
        return idmemr;
    }

    public void setIdmemr(Integer idmemr) {
        this.idmemr = idmemr;
    }

    public String getFormecritmr() {
        return formecritmr;
    }

    public void setFormecritmr(String formecritmr) {
        this.formecritmr = formecritmr;
    }

    public String getFormprononcemr() {
        return formprononcemr;
    }

    public void setFormprononcemr(String formprononcemr) {
        this.formprononcemr = formprononcemr;
    }

    public Langue getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(com.rigo.rigo.entities.Langue idlangue) {
        this.idlangue = idlangue;
    }

    public Motexpressionfr getIdmefr() {
        return idmefr;
    }

    public void setIdmefr(Motexpressionfr idmefr) {
        this.idmefr = idmefr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmemr != null ? idmemr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motexpressionmr)) {
            return false;
        }
        Motexpressionmr other = (Motexpressionmr) object;
        if ((this.idmemr == null && other.idmemr != null) || (this.idmemr != null && !this.idmemr.equals(other.idmemr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Motexpressionmr[ idmemr=" + idmemr + " ]";
    }
    
}
