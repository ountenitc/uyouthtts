/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Motexpressionmr;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface MotexpressionmrService {
    public Motexpressionmr create(Motexpressionmr motexpressionmr);

    public Motexpressionmr update(Motexpressionmr motexpressionfr);

    public Optional<Motexpressionmr> find(Integer idmotexpressionmr);

    public void deleted(Integer idmotexpressionmr);

    public List<Motexpressionmr> findAll();
    
}
