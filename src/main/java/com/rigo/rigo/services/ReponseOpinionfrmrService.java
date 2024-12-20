/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.services;

import com.rigo.rigo.entities.Opinionfrmr;
import com.rigo.rigo.entities.Reponseopinionfrmr;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface ReponseOpinionfrmrService {

    public Reponseopinionfrmr create(Reponseopinionfrmr reponseopinionfrmr);

    public Reponseopinionfrmr update(Reponseopinionfrmr reponseopinionfrmr);

    public Optional<Reponseopinionfrmr> find(Integer id);

    public void deleted(Integer idopinionfrmr);

    public List<Reponseopinionfrmr> findAll();
    
    public List<Reponseopinionfrmr> findByIdropfrmr(Integer id);
}
