/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rigo.rigo.util;

/**
 *
 * @author HP
 */
public class Traduire {
    private String textFr;
    private String langue;
    private String textLangue;

    public Traduire(String textFr, String textLangue) {
        this.textFr = textFr;
        this.textLangue = textLangue;
    }

    public Traduire() {
    }

    public String getTextFr() {
        return textFr;
    }

    public void setTextFr(String textFr) {
        this.textFr = textFr;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getTextLangue() {
        return textLangue;
    }

    public void setTextLangue(String textLangue) {
        this.textLangue = textLangue;
    }
    
    
}
