/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Opinionfrmr;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface OpinionfrmrService {
    public Opinionfrmr create(Opinionfrmr opinionfrmr);

    public Opinionfrmr update(Opinionfrmr opinionfrmr);

    public Optional<Opinionfrmr> find(Integer idopinionfrmr);

    public void deleted(Integer idopinionfrmr);

    public List<Opinionfrmr> findAll();
}
