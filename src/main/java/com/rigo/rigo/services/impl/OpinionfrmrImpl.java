/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Opinionfrmr;
import com.rigo.rigo.repositories.OpinionfrmrRepos;
import com.rigo.rigo.services.OpinionfrmrService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class OpinionfrmrImpl implements OpinionfrmrService {

    @Autowired
    OpinionfrmrRepos repos;

    @Override
    public Opinionfrmr create(Opinionfrmr opinionfrmr) {
        return repos.save(opinionfrmr);
    }

    @Override
    public Opinionfrmr update(Opinionfrmr opinionfrmr) {
        return repos.save(opinionfrmr);
    }

    @Override
    public Optional<Opinionfrmr> find(Integer idopinionfrmr) {
        return repos.findById(idopinionfrmr);
    }

    @Override
    public void deleted(Integer idopinionfrmr) {
        repos.deleteById(idopinionfrmr);
    }

    @Override
    public List<Opinionfrmr> findAll() {
        return repos.findAll();
    }

}
