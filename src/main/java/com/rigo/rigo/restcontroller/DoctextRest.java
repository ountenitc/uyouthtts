/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.restcontroller;

import com.rigo.rigo.entities.Doctext;
import com.rigo.rigo.services.impl.DoctextImpl;
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
@RequestMapping("doctext/")
public class DoctextRest {
     
    @Autowired
    DoctextImpl impl;

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
    public ResponseEntity<List<Doctext>> getAll() {
        List<Doctext> lesDoctext =  new ArrayList<>();
        try {
            lesDoctext = impl.findAll();
            return new ResponseEntity<>(lesDoctext, HttpStatus.OK);
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
    public ResponseEntity<Optional<Doctext>> getById(
            @PathVariable("id") Integer id) {
        Optional<Doctext> doctext;
        try {
            doctext = impl.find(id);
            return new ResponseEntity<>(doctext, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * crée un objet de type alerte dans la base de données 
     * @param doctext
     * @return 
     */
    @PostMapping("create")
    private ResponseEntity<String> create(
            @RequestBody @Valid Doctext doctext) {
        Doctext tmp = new Doctext();
        String msg = "";
        try {
            tmp = impl.create(doctext);
            msg = "Enregistrement du document  : " + tmp.getTitredoc()+ " avec succès.";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    /**
     * modifier l'objet alerte dont l'identifiant est passé en paramettre 
     * @param id
     * @param doctext
     * @return 
     */
    @PutMapping("update/{id}")
    public ResponseEntity<Doctext> updateDoctext(
            @PathVariable("id") Integer id,
            @RequestBody Doctext doctext) {
        try {
            impl.update(doctext);
            return new ResponseEntity<>(doctext, HttpStatus.OK);
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
}
