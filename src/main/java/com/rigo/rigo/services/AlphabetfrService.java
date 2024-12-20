/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Alphabetfr;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface AlphabetfrService {
    public Alphabetfr create(Alphabetfr alphabetfr);

    public Alphabetfr update(Alphabetfr alphabetfr);

    public Optional<Alphabetfr> find(Integer idalphabetfr);

    public void deleted(Integer idalphabetfr);
    
    public List<Alphabetfr> findAll();
}
