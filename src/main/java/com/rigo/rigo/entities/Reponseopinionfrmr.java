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
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "reponseopinionfrmr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reponseopinionfrmr.findAll", query = "SELECT r FROM Reponseopinionfrmr r"),
    @NamedQuery(name = "Reponseopinionfrmr.findByIdropfrmr", query = "SELECT r FROM Reponseopinionfrmr r WHERE r.idropfrmr = :idropfrmr"),
    @NamedQuery(name = "Reponseopinionfrmr.findByReponseopfr", query = "SELECT r FROM Reponseopinionfrmr r WHERE r.reponseopfr = :reponseopfr"),
    @NamedQuery(name = "Reponseopinionfrmr.findByReponseopmr", query = "SELECT r FROM Reponseopinionfrmr r WHERE r.reponseopmr = :reponseopmr"),
    @NamedQuery(name = "Reponseopinionfrmr.findByAudioreponsemr", query = "SELECT r FROM Reponseopinionfrmr r WHERE r.audioreponsemr = :audioreponsemr")})
public class Reponseopinionfrmr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idropfrmr")
    private Integer idropfrmr;
    @Column(name = "reponseopfr")
    private String reponseopfr;
    @Column(name = "reponseopmr")
    private String reponseopmr;
    @Column(name = "audioreponsemr")
    private String audioreponsemr;
    @JoinColumn(name = "idopinionfrmr", referencedColumnName = "idopinionfrmr")
    @ManyToOne
    private Opinionfrmr idopinionfrmr;

    public Reponseopinionfrmr() {
    }

    public Reponseopinionfrmr(Integer idropfrmr) {
        this.idropfrmr = idropfrmr;
    }

    public Integer getIdropfrmr() {
        return idropfrmr;
    }

    public void setIdropfrmr(Integer idropfrmr) {
        this.idropfrmr = idropfrmr;
    }

    public String getReponseopfr() {
        return reponseopfr;
    }

    public void setReponseopfr(String reponseopfr) {
        this.reponseopfr = reponseopfr;
    }

    public String getReponseopmr() {
        return reponseopmr;
    }

    public void setReponseopmr(String reponseopmr) {
        this.reponseopmr = reponseopmr;
    }

    public String getAudioreponsemr() {
        return audioreponsemr;
    }

    public void setAudioreponsemr(String audioreponsemr) {
        this.audioreponsemr = audioreponsemr;
    }

    public Opinionfrmr getIdopinionfrmr() {
        return idopinionfrmr;
    }

    public void setIdopinionfrmr(Opinionfrmr idopinionfrmr) {
        this.idopinionfrmr = idopinionfrmr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idropfrmr != null ? idropfrmr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reponseopinionfrmr)) {
            return false;
        }
        Reponseopinionfrmr other = (Reponseopinionfrmr) object;
        if ((this.idropfrmr == null && other.idropfrmr != null) || (this.idropfrmr != null && !this.idropfrmr.equals(other.idropfrmr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Reponseopinionfrmr[ idropfrmr=" + idropfrmr + " ]";
    }
    
}
