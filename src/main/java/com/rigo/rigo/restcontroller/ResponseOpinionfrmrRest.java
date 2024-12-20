/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.restcontroller;

import com.rigo.rigo.entities.Reponseopinionfrmr;
import com.rigo.rigo.services.impl.ReponseOpinionImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("reponseopinionfrmr/")
public class ResponseOpinionfrmrRest {

    @Autowired
    ReponseOpinionImpl impl;

    @GetMapping("")
    public ResponseEntity<String> welcomme() {
        return new ResponseEntity<>("Bienvenue dans l'espace des reponse des document !!",
                HttpStatus.OK);
    }

    /**
     * @return
     */
    @GetMapping("all")
    public ResponseEntity<List<Reponseopinionfrmr>> getAll() {
        List<Reponseopinionfrmr> lesReponseopinionfrmr = new ArrayList<>();
        try {
            lesReponseopinionfrmr = impl.findAll();
            return new ResponseEntity<>(lesReponseopinionfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * obtenir un objet en fonction de son identifiant(id)
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Optional<Reponseopinionfrmr>> getById(
            @PathVariable("id") Integer id) {
        Optional<Reponseopinionfrmr> opinionfrmr;
        try {
            opinionfrmr = impl.find(id);
            return new ResponseEntity<>(opinionfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * @param opinionfrmr
     * @return
     */
    @PostMapping("create")
    private ResponseEntity<String> create(
            @RequestBody @Valid Reponseopinionfrmr opinionfrmr) {
        Reponseopinionfrmr tmp = new Reponseopinionfrmr();
        String msg = "";
        try {
            tmp = impl.create(opinionfrmr);
            msg = "Enregistrement du texte avec succès.";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     *
     * @param id
     * @param opinionfrmr
     * @return
     */
    @PutMapping("update/{id}")
    public ResponseEntity<Reponseopinionfrmr> update(
            @PathVariable("id") Integer id,
            @RequestBody Reponseopinionfrmr opinionfrmr) {
        try {
            impl.update(opinionfrmr);
            return new ResponseEntity<>(opinionfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /*
    
     */
    @DeleteMapping("delete/{id}")
    private ResponseEntity<String> delete(
            @PathVariable("id") Integer id) {
        String msg = "";
        try {
            impl.deleted(id);
            msg = "Suppression effectuée avec succès.";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /*
    
     */
    @GetMapping("opinion/{id}")
    public ResponseEntity<List<Reponseopinionfrmr>> getByOpinion(
            @PathVariable("id") Integer id) {
        List<Reponseopinionfrmr> lesReponseopinionfrmr = new ArrayList<>();
        try {
            lesReponseopinionfrmr = impl.findByIdropfrmr(id);
            return new ResponseEntity<>(lesReponseopinionfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
