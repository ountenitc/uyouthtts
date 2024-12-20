/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Motexpressionmr;
import com.rigo.rigo.repositories.MotexpressionmrRepos;
import com.rigo.rigo.services.MotexpressionmrService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MotexpressionmrImpl implements MotexpressionmrService {

    @Autowired
    MotexpressionmrRepos repos;

    @Override
    public Motexpressionmr create(Motexpressionmr motexpressionmr) {
        return repos.save(motexpressionmr);
    }

    @Override
    public Motexpressionmr update(Motexpressionmr motexpressionfr) {
        return repos.save(motexpressionfr);
    }

    @Override
    public Optional<Motexpressionmr> find(Integer idmotexpressionmr) {
        return repos.findById(idmotexpressionmr);
    }

    @Override
    public void deleted(Integer idmotexpressionmr) {
        repos.deleteById(idmotexpressionmr);
    }

    @Override
    public List<Motexpressionmr> findAll() {
        return repos.findAll();
    }

    public String findByMotexpressionfr(String motexpressionfr){
        return repos.findByMotexpressionfr(motexpressionfr).getFormecritmr();
    }
}
