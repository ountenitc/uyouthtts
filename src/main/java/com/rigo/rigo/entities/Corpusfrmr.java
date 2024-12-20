package com.rigo.rigo.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Corpusfrmr.findAll", query =
 * "SELECT c FROM Corpusfrmr c order by c.formecritfr asc"),
 * 
 * @NamedQuery(name = "Corpusfrmr.findByIdmemr", query =
 * "SELECT c FROM Corpusfrmr m WHERE c.idcorpusfrmr = :idcorpusfrmr"),
 * 
 * @NamedQuery(name = "Corpusfrmr.findByFormecritfr", query =
 * "SELECT c FROM Corpusfrmr c WHERE c.formecritfr = :formecritfr")})
 */
@Entity
@Data
@Table(name = "corpusfrmr", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"idcorpusfrmr"})})
@NamedQueries({
    @NamedQuery(name = "Corpusfrmr.findAll", query = "SELECT c FROM Corpusfrmr c order by c.formecritfr asc"),
    @NamedQuery(name = "Corpusfrmr.findByIdcorpusfrmr", query = "SELECT c FROM Corpusfrmr c WHERE c.idcorpusfrmr = :idcorpusfrmr"),
    @NamedQuery(name = "Corpusfrmr.findByFormecritfr", query = "SELECT c FROM Corpusfrmr c WHERE c.formecritfr = :formecritfr")})
public class Corpusfrmr implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcorpusfrmr", nullable= false)
    public Integer idcorpusfrmr;
    @Column(name = "formecritfr", length = 1024)
    private String formecritfr;
    @Column(name = "formecritmr", length = 1024)
    private String formecritmr;
    @Column(name = "urlaudio", length = 254)
    private String urlaudio;
}
