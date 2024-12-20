/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Doctext;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface DoctextService {

    public Doctext create(Doctext doctext);

    public Doctext update(Doctext doctext);

    public Optional<Doctext> find(Integer iddoctext);

    public void deleted(Integer iddoctext);

    public List<Doctext> findAll();
}
