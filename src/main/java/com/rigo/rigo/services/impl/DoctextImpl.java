/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Doctext;
import com.rigo.rigo.repositories.DoctextRepos;
import com.rigo.rigo.services.DoctextService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class DoctextImpl implements DoctextService {

    @Autowired
    DoctextRepos repos;

    @Override
    public Doctext create(Doctext doctext) {
        return repos.save(doctext);
    }

    @Override
    public Doctext update(Doctext doctext) {
        return repos.save(doctext);
    }

    @Override
    public Optional<Doctext> find(Integer iddoctext) {
        return repos.findById(iddoctext);
    }

    @Override
    public void deleted(Integer iddoctext) {
        repos.deleteById(iddoctext);
    }

    @Override
    public List<Doctext> findAll() {
        return repos.findAll();
    }

}
