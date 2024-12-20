/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rigo.rigo.repositories;

import com.rigo.rigo.entities.Utilisateur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface UtilisateurRepos extends JpaRepository<Utilisateur, Integer>{
    //Utilisateur findByUsername(String username);    
}
