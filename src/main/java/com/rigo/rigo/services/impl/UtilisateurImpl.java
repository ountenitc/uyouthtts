/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.services.impl;

import com.rigo.rigo.entities.Utilisateur;
import com.rigo.rigo.repositories.UtilisateurRepos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class UtilisateurImpl  {
    
    @Autowired
    private UtilisateurRepos userRepo;
    // @Autowired
    //PasswordEncoder pwdEncoder;
    public Utilisateur create(Utilisateur utilisateur) {
      //  utilisateur.setPassword(pwdEncoder.encode(utilisateur.getPassword()));
        return userRepo.save(utilisateur);
    }
    
    public Utilisateur update(Utilisateur utilisateur) {
        //utilisateur.setPasswordUtilisateur(pwdEncoder.encode(utilisateur.getPasswordUtilisateur()));
        return userRepo.save(utilisateur);
    }
    
    public Utilisateur find(Integer idUtilisateur) {
        return userRepo.findById(idUtilisateur).get();
    }
    
    public List<Utilisateur> findAll() {
        return userRepo.findAll();
    }
    
    /*
    public Utilisateur findByUsername(String login) {
        Utilisateur encours = userRepo.findByUsername(login);
        return encours;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("login en entré : " + username);
        org.springframework.security.core.userdetails.User springUser = null;
        Utilisateur utilisateur = null;
        if (username != "") {
            utilisateur = userRepo.findByUsername(username);
        }
        if (utilisateur != null) {
            springUser = new org.springframework.security.core.userdetails.User(utilisateur.getUsername(),
                    utilisateur.getPassword(), utilisateur.getAuthorities());
            System.out.println("login en sortie : " + utilisateur.getUsername());
            System.out.println("password en sortie : " + utilisateur.getPassword());
            
        } else {
        }
        return springUser;
    }
    */
}
