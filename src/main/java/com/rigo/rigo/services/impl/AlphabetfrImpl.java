/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Alphabetfr;
import com.rigo.rigo.repositories.AlphabetfrRepos;
import com.rigo.rigo.services.AlphabetfrService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class AlphabetfrImpl implements AlphabetfrService {

    @Autowired
    AlphabetfrRepos repos;

    @Override
    public Alphabetfr create(Alphabetfr alphabetfr) {
        return repos.save(alphabetfr);
    }

    @Override
    public Alphabetfr update(Alphabetfr alphabetfr) {
        return repos.save(alphabetfr);
    }

    @Override
    public Optional<Alphabetfr> find(Integer idalphabetfr) {
          return repos.findById(idalphabetfr);
  }

    @Override
    public void deleted(Integer idalphabetfr) {
        repos.deleteById(idalphabetfr);
    }

    @Override
    public List<Alphabetfr> findAll() {
         return repos.findAll();
   }

}
