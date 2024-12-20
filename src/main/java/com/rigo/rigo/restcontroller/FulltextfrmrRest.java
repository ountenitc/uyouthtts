/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.restcontroller;

import com.rigo.rigo.entities.Fulltextfrmr;
import com.rigo.rigo.services.impl.FulltextfrmrImpl;
import com.rigo.rigo.util.Traducteur;
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
@RequestMapping("fulltextfrmr/")
public class FulltextfrmrRest {
    @Autowired
    FulltextfrmrImpl impl;
   
    Traducteur tr;

    @GetMapping("")
    public ResponseEntity<String> welcomme() {
        return new ResponseEntity<>("Bienvenue dans l'espace des document !!",
                HttpStatus.OK);
    }

    /**
     * liste tous les alertes des expressions se trouvant dans la base de données 
     * @return 
     */
    @GetMapping("all")
    public ResponseEntity<List<Fulltextfrmr>> getAll() {
        List<Fulltextfrmr> lesFulltextfrmr =  new ArrayList<>();
        try {
            lesFulltextfrmr = impl.findAll();
            return new ResponseEntity<>(lesFulltextfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * obtenir un objet alerte en fonction de son identifiant(id) 
     * @param id
     * @return 
     */
    @GetMapping("{id}")
    public ResponseEntity<Optional<Fulltextfrmr>> getById(
            @PathVariable("id") Integer id) {
        Optional<Fulltextfrmr> fulltextfrmr;
        try {
            fulltextfrmr = impl.find(id);
            return new ResponseEntity<>(fulltextfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * crée un objet de type alerte dans la base de données 
     * @param fulltextfrmr
     * @return 
     */
    @PostMapping("create")
    private ResponseEntity<String> create(
            @RequestBody @Valid Fulltextfrmr fulltextfrmr) {
        Fulltextfrmr tmp = new Fulltextfrmr();
        String msg = "";
        try {
            tmp = impl.create(fulltextfrmr);
            msg = "Enregistrement du texte avec succès.";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    /**
     * modifier l'objet alerte dont l'identifiant est passé en paramettre 
     * @param id
     * @param fulltextfrmr
     * @return 
     */
    @PutMapping("update/{id}")
    public ResponseEntity<Fulltextfrmr> updateFulltextfrmr(
            @PathVariable("id") Integer id,
            @RequestBody Fulltextfrmr fulltextfrmr) {
        try {
            impl.update(fulltextfrmr);
            return new ResponseEntity<>(fulltextfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    
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
//    @PostMapping("generertextmr")
//    public ResponseEntity<String> genererTextMr(@RequestBody String textFr) {
//        String textMr = tr.traducteur(textFr);
//        return new ResponseEntity<>(textMr,HttpStatus.OK);
//    }

//    @GetMapping("genereraudiomr")
//    public ResponseEntity<String> genererAudioTextMr(@RequestBody String textFr) {
//        String textMr = tr.lireText(textFr);
//        return new ResponseEntity<>(textMr,HttpStatus.OK);
//    }

}