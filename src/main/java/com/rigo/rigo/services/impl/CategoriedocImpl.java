/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Categoriedoc;
import com.rigo.rigo.repositories.CategoriedocRepos;
import com.rigo.rigo.services.CategoriedocService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CategoriedocImpl implements CategoriedocService {

    @Autowired
    CategoriedocRepos repos;

    @Override
    public Categoriedoc create(Categoriedoc categoriedoc) {
        return repos.save(categoriedoc);
    }

    @Override
    public Categoriedoc update(Categoriedoc categoriedoc) {
        return repos.save(categoriedoc);
    }

    @Override
    public Optional<Categoriedoc> find(Integer idcategoriedoc) {
        return repos.findById(idcategoriedoc);
    }

    @Override
    public void deleted(Integer idcategoriedoc) {
        repos.deleteById(idcategoriedoc);
    }

    @Override
    public List<Categoriedoc> findAll() {
        return repos.findAll();
    }

}
