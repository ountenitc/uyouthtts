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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
@Table(name = "doctext", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"iddoctext"})})
@NamedQueries({
   // @NamedQuery(name = "Doctext.findAll", query = "SELECT d FROM Doctext d"),
  //  @NamedQuery(name = "Doctext.findByIddoctext", query = "SELECT d FROM Doctext d WHERE d.iddoctext = :iddoctext"),
   // @NamedQuery(name = "Doctext.findByDatedoc", query = "SELECT d FROM Doctext d WHERE d.datedoc = :datedoc"),
   // @NamedQuery(name = "Doctext.findByTitredoc", query = "SELECT d FROM Doctext d WHERE d.titredoc = :titredoc"),
    //@NamedQuery(name = "Doctext.findByOpaudiomrtitredoc", query = "SELECT d FROM Doctext d WHERE d.opaudiomrtitredoc = :opaudiomrtitredoc")
})
public class Doctext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddoctext", nullable = false)
    private Integer iddoctext;
    @Column(name = "datedoc")
    @Temporal(TemporalType.DATE)
    private Date datedoc;
    @Column(name = "titrefrdoc", length = 254)
    private String titrefrdoc;
    @Column(name = "titremrdoc", length = 254)
    private String titremrdoc;
    @Column(name = "audiotitremrdoc", length = 254)
    private String audiotitremrdoc;
    @OneToMany(mappedBy = "iddoctext")
    @JsonIgnore
    private Collection<Fulltextfrmr> fulltextfrmrCollection;
    @JoinColumn(name = "idcatdoc", referencedColumnName = "idcatdoc")
    @ManyToOne
    private Categoriedoc idcatdoc;
    @JsonIgnore
    @OneToMany(mappedBy = "iddoctext")
    private Collection<Opinionfrmr> opinionfrmrCollection;

    public Doctext() {
    }

    public Doctext(Integer iddoctext) {
        this.iddoctext = iddoctext;
    }

    public Integer getIddoctext() {
        return iddoctext;
    }

    public void setIddoctext(Integer iddoctext) {
        this.iddoctext = iddoctext;
    }

    public Date getDatedoc() {
        return datedoc;
    }

    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
    }

    public String getTitredoc() {
        return titrefrdoc;
    }

    public void setTitredoc(String titredoc) {
        this.titrefrdoc = titredoc;
    }
      public String getTitremrdoc() {
        return titremrdoc;
    }

    public void setTitremrdoc(String titremrdoc) {
        this.titremrdoc = titremrdoc;
    }

    public String getOpaudiomrtitredoc() {
        return audiotitremrdoc;
    }

    public void setOpaudiomrtitredoc(String audiotitremrdoc) {
        this.audiotitremrdoc = audiotitremrdoc;
    }

    @XmlTransient
    public Collection<Fulltextfrmr> getFulltextfrmrCollection() {
        return fulltextfrmrCollection;
    }

    public void setFulltextfrmrCollection(Collection<Fulltextfrmr> fulltextfrmrCollection) {
        this.fulltextfrmrCollection = fulltextfrmrCollection;
    }

    public Categoriedoc getIdcatdoc() {
        return idcatdoc;
    }

    public void setIdcatdoc(Categoriedoc idcatdoc) {
        this.idcatdoc = idcatdoc;
    }

    @XmlTransient
    public Collection<Opinionfrmr> getOpinionfrmrCollection() {
        return opinionfrmrCollection;
    }

    public void setOpinionfrmrCollection(Collection<Opinionfrmr> opinionfrmrCollection) {
        this.opinionfrmrCollection = opinionfrmrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoctext != null ? iddoctext.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctext)) {
            return false;
        }
        Doctext other = (Doctext) object;
        if ((this.iddoctext == null && other.iddoctext != null) || (this.iddoctext != null && !this.iddoctext.equals(other.iddoctext))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rigo.rigo.entities.Doctext[ iddoctext=" + iddoctext + " ]";
    }

}
