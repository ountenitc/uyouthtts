package com.rigo.rigo.restcontroller;

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

import com.rigo.rigo.entities.Corpusfrmr;
import com.rigo.rigo.services.impl.CorpusfrmrImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("corpusfrmr/")
public class CorpusfrmrRest {
	
	@Autowired
	CorpusfrmrImpl impl;
	
	@GetMapping("")
    public ResponseEntity<String> welcomme() {
        return new ResponseEntity<>("Bienvenue dans l'espace des document !!",
                HttpStatus.OK);
    }

    /**
     * liste tous les mot et expressions se trouvant dans le corpus
     * @return 
     */
    @GetMapping("all")
    public ResponseEntity<List<Corpusfrmr>> getAll() {
        List<Corpusfrmr> lesCorpusfrmr =  new ArrayList<>();
        try {
        	lesCorpusfrmr = impl.findAll();
            return new ResponseEntity<>(lesCorpusfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * obtenir un objet corpusfrmr en fonction de son identifiant(id) 
     * @param id
     * @return 
     */
    @GetMapping("{id}")
    public ResponseEntity<Optional<Corpusfrmr>> getById(@PathVariable("id") Integer id) {
        Optional<Corpusfrmr> corpusfrmr;
        try {
        	corpusfrmr = impl.find(id);
            return new ResponseEntity<>(corpusfrmr, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    /**
     * crée un objet de type corpusfrmr dans la base de données 
     * @param motexpressionmr
     * @return 
     */
    @PostMapping("create")
    private ResponseEntity<Corpusfrmr> create(@RequestBody @Valid Corpusfrmr corpusfrmr) {
    	Corpusfrmr tmp = new Corpusfrmr();
        try {
            tmp = impl.create(corpusfrmr);
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
    public ResponseEntity<Corpusfrmr> update(@PathVariable("id") Integer id, @RequestBody Corpusfrmr corpusfrmr) {
        try {
            impl.update(corpusfrmr);
            return new ResponseEntity<>(corpusfrmr, HttpStatus.OK);
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
