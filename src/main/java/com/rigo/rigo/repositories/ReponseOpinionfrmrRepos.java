/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.repositories;

import com.rigo.rigo.entities.Opinionfrmr;
import com.rigo.rigo.entities.Reponseopinionfrmr;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface ReponseOpinionfrmrRepos extends JpaRepository<Reponseopinionfrmr, Integer>{ 
    @Query("Select  r from Reponseopinionfrmr r where r.idopinionfrmr.idopinionfrmr = ?1")
    List<Reponseopinionfrmr> findByIdopinionfrmr(Integer opinion);
}
