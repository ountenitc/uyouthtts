/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Opinionfrmr;
import com.rigo.rigo.entities.Reponseopinionfrmr;
import com.rigo.rigo.repositories.ReponseOpinionfrmrRepos;
import com.rigo.rigo.services.ReponseOpinionfrmrService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ReponseOpinionImpl implements ReponseOpinionfrmrService {

    @Autowired
    ReponseOpinionfrmrRepos repos;

    @Override
    public Reponseopinionfrmr create(Reponseopinionfrmr reponseopinionfrmr) {
        return repos.save(reponseopinionfrmr);
    }

    @Override
    public Reponseopinionfrmr update(Reponseopinionfrmr reponseopinionfrmr) {
        return repos.save(reponseopinionfrmr);
    }

    @Override
    public Optional<Reponseopinionfrmr> find(Integer id) {
        return repos.findById(id);
    }

    @Override
    public void deleted(Integer id) {
        repos.deleteById(id);
    }

    @Override
    public List<Reponseopinionfrmr> findAll() {
        return repos.findAll();
    }

    @Override
    public List<Reponseopinionfrmr> findByIdropfrmr(Integer id) {
        return repos.findByIdopinionfrmr(id);
    }

}
