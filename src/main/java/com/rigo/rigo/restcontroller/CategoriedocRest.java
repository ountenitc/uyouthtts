/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.restcontroller;

import com.rigo.rigo.entities.Categoriedoc;
import com.rigo.rigo.services.impl.CategoriedocImpl;
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
@RequestMapping("categoriedoc/")
public class CategoriedocRest {
    
    @Autowired
    CategoriedocImpl impl;

    @GetMapping("")
    public ResponseEntity<String> welcomme() {
        return new ResponseEntity<>("Bienvenue dans l'espace des categories francais!!",
                HttpStatus.OK);
    }

    /**
     * liste tous les alertes des expressions se trouvant dans la base de données 
     * @return 
     */
    @GetMapping("all")
    public ResponseEntity<List<Categoriedoc>> getAll() {
        List<Categoriedoc> lesCategoriedoc =  new ArrayList<>();
        try {
            lesCategoriedoc = impl.findAll();
            return new ResponseEntity<>(lesCategoriedoc, HttpStatus.OK);
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
    public ResponseEntity<Optional<Categoriedoc>> getById(
            @PathVariable("id") Integer id) {
        Optional<Categoriedoc> categoriedoc;
        try {
            categoriedoc = impl.find(id);
            return new ResponseEntity<>(categoriedoc, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * crée un objet de type alerte dans la base de données 
     * @param categoriedoc
     * @return 
     */
    @PostMapping("create")
    private ResponseEntity<String> create(
            @RequestBody @Valid Categoriedoc categoriedoc) {
        Categoriedoc tmp = new Categoriedoc();
        String msg = "";
        try {
            tmp = impl.create(categoriedoc);
            msg = "Enregistrement de la catégorie document  : " + tmp.getLibcatdoc()+ " avec succès.";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    /**
     * modifier l'objet alerte dont l'identifiant est passé en paramettre 
     * @param id
     * @param categoriedoc
     * @return 
     */
    @PutMapping("update/{id}")
    public ResponseEntity<Categoriedoc> updateCategoriedoc(
            @PathVariable("id") Integer id,
            @RequestBody Categoriedoc categoriedoc) {
        try {
            impl.update(categoriedoc);
            return new ResponseEntity<>(categoriedoc, HttpStatus.OK);
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
