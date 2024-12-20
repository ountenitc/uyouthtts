/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Motexpressionfr;
import com.rigo.rigo.repositories.MotexpressionfrRepos;
import com.rigo.rigo.services.MotexpressionfrService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MotexpressionfrImpl implements MotexpressionfrService {

    @Autowired
    MotexpressionfrRepos repos;

    @Override
    public Motexpressionfr create(Motexpressionfr motexpressionfr) {
        return repos.save(motexpressionfr);
    }

    @Override
    public Motexpressionfr update(Motexpressionfr motexpressionfr) {
        return repos.save(motexpressionfr);
    }

    @Override
    public Optional<Motexpressionfr> find(Integer idmotexpressionfr) {
        return repos.findById(idmotexpressionfr);
    }

    @Override
    public void deleted(Integer idmotexpressionfr) {
        repos.deleteById(idmotexpressionfr);
    }

    @Override
    public List<Motexpressionfr> findAll() {
        return repos.findAll();
    }

}
