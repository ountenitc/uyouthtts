/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Fulltextfrmr;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface FulltextfrmrService {

    public Fulltextfrmr create(Fulltextfrmr fulltextfrmr);

    public Fulltextfrmr update(Fulltextfrmr fulltextfrmr);

    public Optional<Fulltextfrmr> find(Integer idfulltextfrmr);

    public void deleted(Integer idfulltextfrmr);

    public List<Fulltextfrmr> findAll();
}
