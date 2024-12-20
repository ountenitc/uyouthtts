/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.restcontroller;

import com.rigo.rigo.entities.Utilisateur;
import com.rigo.rigo.services.impl.UtilisateurImpl;
import com.rigo.rigo.util.AuthenticationRequest;
import com.rigo.rigo.util.AuthenticationResponse;
import com.rigo.rigo.util.JwtService;
import com.rigo.rigo.util.SecurityConstants;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *origins = "*", exposedHeaders = "token"
 * @author HP
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("utilisateur/")
public class UtilisateurRest {

    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    UtilisateurImpl utilisateurService;
  
    @Autowired
    JwtService jwtService;
    HttpHeaders headers = new HttpHeaders();

    @GetMapping("")
    public ResponseEntity<String> welcomme() {
        return new ResponseEntity<>("Bienvenue dans l'espace utilisateur!!", HttpStatus.OK);
    }

    @GetMapping("all")
    private ResponseEntity<List<Utilisateur>> getAllUtilisateur() {
        try {
            List<Utilisateur> tmp = new ArrayList<>();
            tmp = utilisateurService.findAll();
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        } catch (Exception ex) {
            logger.info("Exception error: " + ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    /*
    @PostMapping("create")
    private ResponseEntity<String> create(@RequestBody Utilisateur utilisateur) {
        String msg = "";
        try {
            Utilisateur tmp = new Utilisateur();
            if (utilisateurService.loadUserByUsername(utilisateur.getUsername()) == null) {
               
                tmp = utilisateurService.create(utilisateur);
                msg = " Utilisateur créer avec succès!";
            } else {
                msg = " L'utilisateur existe!";
            }
            return new ResponseEntity<>(msg, HttpStatus.OK);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error", e);
        }
    }
    */
    /*
    @PostMapping("authentifier")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest request) {
        String uname = ((UserDetails) request).getUsername();
        AuthenticationResponse authResp = new AuthenticationResponse();
        //HttpHeaders headers = new HttpHeaders();
        System.out.println("début ");
        try {
            System.out.println("username: " + ((UserDetails) request).getUsername());
            
            UserDetails tmp = utilisateurService.loadUserByUsername(uname);
            
            if (tmp != null && pwdEncoder.matches(((UserDetails) request).getPassword(), tmp.getPassword())) {
                Utilisateur user = utilisateurService.findByUsername(tmp.getUsername());
              UserDetails userDetailsCon = user;
               // String token = JwtService.generateToken(userDetailsCon);
                
                authResp.setUser(user);
              //  authResp.setToken(token);
               // System.out.println("token: " + token);
                
               // headers.set(SecurityConstants.AUTH_HEADER, SecurityConstants.BEARER_TOKEN_PREFIX + token);
                return new ResponseEntity<>(authResp, headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            logger.info("Exception error: " + ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }


//    @PostMapping("authentifier")
//    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest request) {
//        String uname = request.getUsername();
//        Utilisateur user = new Utilisateur();
//        headers = new HttpHeaders();
//        AuthenticationResponse authResp = new AuthenticationResponse();
//        try {
//            System.out.println("uername:"+ request.getUsername());
//            UserDetails tmp = utilisateurService.loadUserByUsername(uname);
//            if (tmp != null && pwdEncoder.matches(request.getPassword(), tmp.getPassword())) {
//                user = utilisateurService.findByUsername(tmp.getUsername());
//                UserDetails userDetailsCon = user;
//                String token = JwtService.generateToken(userDetailsCon);
//                authResp.setUser(user);
//                authResp.setToken(token);
//                System.out.println("token:"+ token);
//                headers.set(SecurityConstants.AUTH_HEADER, SecurityConstants.BEARER_TOKEN_PREFIX + token);
//            }
//            return ResponseEntity.ok(authResp);
//        } catch (Exception ex) {
//            logger.info("Exception error: " + ex.getMessage());
//            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
//        }
//    }
/*
    @PostMapping("update/{id}")
    private ResponseEntity<String> update(@PathVariable("id") Integer id,
            @RequestBody Utilisateur utilisateur, @RequestHeader(name = "Authorization") String token,
            @RequestParam(value = "user", defaultValue = "") String user) {
        String username = jwtService.extractUsername(token);
        String msg = "";
        try {
            if (jwtService.isTokenValid(token, user)) {
                Utilisateur user1 = utilisateurService.find(id);
                utilisateurService.update(user1);
                msg = "Mot de passe modifié avec succès.";
            } else {
                msg = "Le mot de passe ne correspond pas au critère défini.";
            }

            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

*/
    /*
   @GetMapping("{id}")
    private ResponseEntity<Utilisateur> findById(@PathVariable("id") Integer id) {
        try {
            Utilisateur tmp = utilisateurService.find(id);
             return new ResponseEntity<>(tmp, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
*/
}
