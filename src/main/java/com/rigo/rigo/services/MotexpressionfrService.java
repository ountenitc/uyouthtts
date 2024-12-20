/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Motexpressionfr;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface MotexpressionfrService {
    public Motexpressionfr create(Motexpressionfr motexpressionfr);

    public Motexpressionfr update(Motexpressionfr motexpressionfr);

    public Optional<Motexpressionfr> find(Integer idmotexpressionfr);

    public void deleted(Integer idmotexpressionfr);

    public List<Motexpressionfr> findAll();
}
