/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Fulltextfrmr;
import com.rigo.rigo.repositories.FulltextfrmrRepos;
import com.rigo.rigo.services.FulltextfrmrService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class FulltextfrmrImpl implements FulltextfrmrService {

    @Autowired
    FulltextfrmrRepos repos;

    @Override
    public Fulltextfrmr create(Fulltextfrmr fulltextfrmr) {
        return repos.save(fulltextfrmr);
    }

    @Override
    public Fulltextfrmr update(Fulltextfrmr fulltextfrmr) {
        return repos.save(fulltextfrmr);
    }

    @Override
    public Optional<Fulltextfrmr> find(Integer idfulltextfrmr) {
        return repos.findById(idfulltextfrmr);
    }

    @Override
    public void deleted(Integer idfulltextfrmr) {
        repos.deleteById(idfulltextfrmr);
    }

    @Override
    public List<Fulltextfrmr> findAll() {
        return repos.findAll();
    }

}
