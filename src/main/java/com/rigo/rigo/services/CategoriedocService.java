/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Categoriedoc;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface CategoriedocService {

    public Categoriedoc create(Categoriedoc categoriedoc);

    public Categoriedoc update(Categoriedoc categoriedoc);

    public Optional<Categoriedoc> find(Integer idcategoriedoc);

    public void deleted(Integer idcategoriedoc);

    public List<Categoriedoc> findAll();

}
