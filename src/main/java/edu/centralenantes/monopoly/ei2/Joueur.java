/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

/**
 *
 * @author inky19
 */
public class Joueur {
    String nom;
    int fortune;
    int indexCase;
    boolean enPrison;

    public Joueur(String nom, int fortune, int indexCase, boolean enPrison) {
        this.nom = nom;
        this.fortune = fortune;
        this.indexCase = indexCase;
        this.enPrison = enPrison;
    }

    public Joueur() {
        this.nom = "Bob";
        this.fortune = 0;
        this.indexCase = 0;
        this.enPrison = false;
    }
    
    public Joueur(Joueur j) {
        this.nom = j.nom;
        this.fortune = j.fortune;
        this.indexCase = j.indexCase;
        this.enPrison = j.enPrison;
    }

    public String getNom() {
        return nom;
    }

    public int getFortune() {
        return fortune;
    }

    public int getIndexCase() {
        return indexCase;
    }

    public boolean isEnPrison() {
        return enPrison;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    public void setIndexCase(int indexCase) {
        this.indexCase = indexCase;
    }

    public void setEnPrison(boolean enPrison) {
        this.enPrison = enPrison;
    }
    
    
    
    

}
