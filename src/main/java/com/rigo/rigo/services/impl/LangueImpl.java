/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Langue;
import com.rigo.rigo.repositories.LangueRepos;
import com.rigo.rigo.services.LangueService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class LangueImpl implements LangueService {

    @Autowired
    LangueRepos repos;

    @Override
    public Langue create(Langue langue) {
        return repos.save(langue);
    }

    @Override
    public Langue update(Langue langue) {
        return repos.save(langue);
    }

    @Override
    public Optional<Langue> find(Integer idlangue) {
        return repos.findById(idlangue);
    }

    @Override
    public void deleted(Integer idlangue) {
        repos.deleteById(idlangue);
    }

    @Override
    public List<Langue> findAll() {
        return repos.findAll();
    }

}
