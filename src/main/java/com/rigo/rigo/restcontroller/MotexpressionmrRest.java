/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.restcontroller;


import com.rigo.rigo.entities.Motexpressionmr;
import com.rigo.rigo.services.impl.MotexpressionmrImpl;
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
@RequestMapping("motexpressionmr/")
public class MotexpressionmrRest {
      
 @Autowired
   MotexpressionmrImpl impl;
 @Autowired
 // LangueImpl langueService;
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
    public ResponseEntity<List<Motexpressionmr>> getAll() {
        List<Motexpressionmr> lesMotexpressionmr =  new ArrayList<>();
        try {
            lesMotexpressionmr = impl.findAll();
            return new ResponseEntity<>(lesMotexpressionmr, HttpStatus.OK);
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
    public ResponseEntity<Optional<Motexpressionmr>> getById(
            @PathVariable("id") Integer id) {
        Optional<Motexpressionmr> motexpressionmr;
        try {
            motexpressionmr = impl.find(id);
            return new ResponseEntity<>(motexpressionmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * crée un objet de type alerte dans la base de données 
     * @param motexpressionmr
     * @return 
     */
    @PostMapping("create")
    private ResponseEntity<Motexpressionmr> create(
            @RequestBody @Valid Motexpressionmr motexpressionmr) {
        Motexpressionmr tmp = new Motexpressionmr();
        String msg = "";
        try {
            tmp = impl.create(motexpressionmr);
            msg = "Enregistrement du texte avec succès.";
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    /**
     * modifier l'objet alerte dont l'identifiant est passé en paramettre 
     * @param id
     * @param motexpressionmr
     * @return 
     */
    @PutMapping("update/{id}")
    public ResponseEntity<Motexpressionmr> update(
            @PathVariable("id") Integer id,
            @RequestBody Motexpressionmr motexpressionmr) {
        try {
            impl.update(motexpressionmr);
            return new ResponseEntity<>(motexpressionmr, HttpStatus.OK);
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
