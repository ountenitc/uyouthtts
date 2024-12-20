/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Alertetext;
import com.rigo.rigo.repositories.AlertetextRepos;
import com.rigo.rigo.services.AlertetextService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class AlertetextImpl implements AlertetextService {

    @Autowired
    AlertetextRepos repos;

    @Override
    public Alertetext create(Alertetext alertetext) {
        return repos.save(alertetext);
    }

    @Override
    public Alertetext update(Alertetext alertetext) {
        return repos.save(alertetext);
    }

    @Override
    public Optional<Alertetext> find(Integer idalertetext) {
        return repos.findById(idalertetext);
    }

    @Override
    public void deleted(Integer idalertetext) {
        repos.deleteById(idalertetext);
    }

    @Override
    public List<Alertetext> findAll() {
        return repos.findAll();
    }

}
