/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

import edu.centralenantes.monopoly.ei2.Case.Achetable;
import java.util.ArrayList;

/**
 *
 * @author inky19
 */
public class Joueur {
    String nom;
    int fortune;
    int indexCase;
    boolean enPrison;
    int nbGare;
    Plateau plateau;
    public static final int FORTUNE_INITIALE = 100000;
    public Joueur(String nom, int fortune, int indexCase, boolean enPrison, int nbGare, Plateau plateau) {
        this.nom = nom;
        this.fortune = fortune;
        this.indexCase = indexCase;
        this.enPrison = enPrison;
        this.nbGare = nbGare;
        this.plateau = plateau;
    }
    
    public Joueur() {
        this.nom = "Bob";
        this.fortune = 10000;
        this.indexCase = 0;
        this.enPrison = false;
        this.nbGare = 0;
        this.plateau = plateau;
    }
    public Joueur(String nom, Plateau plateau){
        this.nom = nom;
        this.fortune = FORTUNE_INITIALE;
        this.indexCase = 0;
    }

    
    public void payer(Joueur j, int payement) throws NoMoreMoney {
        if (this.fortune < payement) {
            throw new NoMoreMoney();
            }
        this.fortune = this.fortune - payement;
        j.setFortune(j.getFortune()+ payement);
    }


    public Joueur(Joueur j) {
        this.nom = j.nom;
        this.fortune = j.fortune;
        this.indexCase = j.indexCase;
        this.enPrison = j.enPrison;
        }

    
    public void payerBanque(int payement) throws NoMoreMoney{
        if (this.fortune < payement) {
            throw new NoMoreMoney();
    }
        this.fortune = this.fortune - payement;
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


    public int getNbGare() {
        return nbGare;
    }

    public void setNbGare(int nbGare) {
        this.nbGare = nbGare;
    }
    public void gagnerArgent(int gain){
        this.fortune = this.fortune + gain;
    }
    
    public ArrayList<Achetable> proprietes(){
        for(Case c : this.plateau.cases) {
            
}
    }
    
    
    
    

    public void avance(int nbCaseAvance) {
        int newIndex = indexCase + nbCaseAvance;
        if (newIndex >= 40) {
            newIndex = newIndex % 40;
            this.gagnerArgent(20000);
        }
    }


}
