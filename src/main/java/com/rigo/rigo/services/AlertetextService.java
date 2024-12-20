/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Alertetext;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface AlertetextService {

    public Alertetext create(Alertetext alertetext);

    public Alertetext update(Alertetext alertetext);

    public Optional<Alertetext> find(Integer idalertetext);

    public void deleted(Integer idalertetext);
    
    public List<Alertetext> findAll();

}
