/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.util;

import com.google.api.gax.core.CredentialsProvider;
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.rigo.rigo.entities.Alertetext;
import com.rigo.rigo.services.impl.AlertetextImpl;
import com.rigo.rigo.services.impl.MotexpressionmrImpl;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javazoom.jl.decoder.JavaLayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author HP
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("util/")
public class Traducteur {

    @Autowired
    MotexpressionmrImpl impl;
    @Autowired
    AlertetextImpl alerteImpl;

    private CredentialsProvider credentialsProvider;

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    /*
    fonction de tokenisation avec delimiteur explicite. cette fonction est à appler si le delimieur est different de espace 
     */
    public List<String> getTokens(String str, String delimiter) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, delimiter);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    /*
       fonction de tokenisation sans delimiteur explicite donc espace par defaut
     */
    public List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    /*
       utilisation de l'API de google TTS pour la generation de l'audio  du texte passé en paramètre.
     */
    public String synthesizeText(String text) throws Exception {
        // Instantiates a client
        String audioname = "";
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            // Set the text input to be synthesized
            SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();
            System.err.println("Sytehetiseur input " + input.getText());
            // Build the voice request
            VoiceSelectionParams voice
                    = VoiceSelectionParams.newBuilder()
                            .setLanguageCode("fr-FR") // languageCode = "en_us"
                            .setSsmlGender(SsmlVoiceGender.MALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
                            .build();

            // Select the type of audio file you want returned
            AudioConfig audioConfig
                    = AudioConfig.newBuilder()
                            .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
                            .build();

            // Perform the text-to-speech request
            SynthesizeSpeechResponse response
                    = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

            // Get the audio contents from the response
            ByteString audioContents = response.getAudioContent();

            // Write the response to the output file.
            audioname = "audio_" + Math.random() + ".mp3";
            try (OutputStream out = new FileOutputStream(SecurityConstants.urlAudio + audioname)) {
                out.write(audioContents.toByteArray());
                System.out.println("Audio content written to file " + audioname);
                // return audioContents;
            }
        }
        return audioname;
    }

    /* 
     cette fonction permet de trouver la correspondance d'une expression en moore
     */
    public String traduireMot(String motFR) {
        String motMr = null;
        if ("".equals(motFR)) {
            System.out.println("Aucune expression ou mot à traduire");
        } else {
            try {
                if (".".equals(motFR.substring(motFR.length() - 1, motFR.length()))
                        || ",".equals(motFR.substring(motFR.length() - 1, motFR.length()))
                        || ";".equals(motFR.substring(motFR.length() - 1, motFR.length()))
                        || "!".equals(motFR.substring(motFR.length() - 1, motFR.length()))
                        || "?".equals(motFR.substring(motFR.length() - 1, motFR.length()))) {
                    String motfr = motFR.substring(0, motFR.length() - 1);
                    motMr = impl.findByMotexpressionfr(motFR.substring(0, motFR.length() - 1)) + motFR.substring(motFR.length() - 1, motFR.length());
                    System.err.println(motFR);
                    System.err.println(motfr);
                } else {
                    motMr = impl.findByMotexpressionfr(motFR);
                }
            } catch (Exception e) {
                e.getCause();
            }
        }
        return motMr;
    }

    /*
    * cette fonction permet de reconstruire la phrase en moore
     */
    public String constructeurMr(List<String> motsMr) {
        String phraseMr = "";
        for (int i = 0; i < motsMr.size(); i++) {
            phraseMr = phraseMr + motsMr.get(i) + " ";
        }
        return phraseMr;
    }

    /*
        cette fonction permet d'enregistrer une alerte : 
     */
    public void saveAlert(String expression) {
        Alertetext alerte = new Alertetext();
        alerte.setDatetxt(new Date());
        alerte.setMotexp(expression);
        alerteImpl.create(alerte);
    }

    /**
     *
     * api de la plateforme
     */
    /* cet api permet de tokeniser une phrase recu en paramettre de traduire mot par mot et en fin de construire le texte en mooré */
    @PostMapping("traduiretext")
    private ResponseEntity<Traduire> traducteur(@RequestBody String textFr) {
        String textMr = null;
        Traduire traduire = new Traduire();
        List<String> motsFr = new ArrayList<>();
        List<String> motsMr = new ArrayList<>();
        System.out.println(motsFr);
        try {
            if (textFr == null) {
            } else {
               /* motsFr = getTokens(textFr, "."); // 
                System.out.println(motsFr);
                if (!motsFr.isEmpty()) {
                    int i = 0;
                    do {
                        String motMr = traduireMot(motsFr.get(i)); // appel de la fonction de recherche de correspondance 
                        if (motMr != null) {
                            motsMr.add(motMr);
                        } else {
                            saveAlert(motsFr.get(i));
                        }
                        i++;
                    } while (i < motsFr.size());
                } else {*/
                    motsFr = getTokens(textFr);
                    if (!motsFr.isEmpty()) {
                        int i = 0;
                        do {
                            String motMr = traduireMot(motsFr.get(i)); // appel de la fonction de recherche de correspondance 
                            if (motMr != null) {
                                motsMr.add(motMr);
                            } else {
                                saveAlert(motsFr.get(i));
                            }
                            i++;
                        } while (i < motsFr.size());
                    }
               // }
            }
            textMr = constructeurMr(motsMr);
            traduire.setTextFr(textFr);
            traduire.setTextLangue(textMr);
            traduire.setLangue("Mooré");
            return new ResponseEntity<>(traduire, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /*
    cet API permet de generer l'audio d'un texte passé en paramètre.
     */
//    @PostMapping("genereraudio")
//    private ResponseEntity<String> textToSpeech(@RequestBody String textMr) throws Exception {
//        String nomaudio = synthesizeText(textMr);
//        return new ResponseEntity<>(nomaudio, HttpStatus.OK);
//    }
    @PostMapping("genereraudio")
    private ResponseEntity<Audio> textToSpeech(@RequestBody String textMr) throws Exception {
        Audio audio = new Audio();
        String nomaudio = synthesizeText(textMr);
        audio.setNomaudio(nomaudio);
        audio.setTextMR(textMr);
        return new ResponseEntity<>(audio, HttpStatus.OK);
    }



    /*
      cet API permet de lire un fichier aufion dont le nom est passé en paramètre
     */
    @GetMapping("lireaudio/{audio}")
    private ResponseEntity<byte[]> lireAudio(@PathVariable("audio") String audio) throws FileNotFoundException, JavaLayerException {

        try {
            byte[] audioencour = null;
            Path aud = Paths.get(SecurityConstants.urlAudio + audio);
            audioencour = Files.readAllBytes(aud);
            return new ResponseEntity<>(audioencour, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
