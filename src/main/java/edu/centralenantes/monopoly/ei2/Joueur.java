/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

import edu.centralenantes.monopoly.ei2.Case.Achetable;
import edu.centralenantes.monopoly.ei2.Case.*;
import edu.centralenantes.monopoly.ei2.Case.Taxe;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    public String getNom() {
        return nom;
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
        ArrayList<Achetable> res = new ArrayList<>();
        for(Case c : this.plateau.cases) {
            if(c instanceof Achetable){
                Achetable manip = (Achetable)c;
                if(manip.getProprietaire().equals(this)){
                    res.add(manip);
                }
            }
}
            return res;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        return Objects.equals(this.nom, other.nom);
    }

    @Override
    public String toString() {
        return "Joueur{" + '}';
    }
    
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }
    
    

    public void avance(int nbCaseAvance) {
        int newIndex = indexCase + nbCaseAvance;
        if (newIndex >= 40) {
            newIndex = newIndex % 40;
            this.gagnerArgent(20000);
        }
        this.indexCase = newIndex;
    }

    
    public void tourDuJoueur(Plateau p) {
        System.out.println("C'est le tour du joueur: " + this.nom);
        System.out.println(this.nom + " possède " + this.fortune);
        int de1 = 0;
        int de2 = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (de1 == de2 && count < 3) {
            de1 = lanceLeDe();
            de2 = lanceLeDe();
            this.avance(de1+de2); 
            System.out.println(nom + " est sur la case: " + p.getCases().get(indexCase).getNom());
            if (p.getCases().get(indexCase) instanceof Achetable) {
                if (p.getCases().get(indexCase).getProprietaire == null) {
                    System.out.println("La propriété vaut: " + p.getCases().get(indexCase).getPrix());
                    System.out.println("Voulez-vous acheter la propriété ?");
                    System.out.println("Oui|Non");
                    String choix = sc.nextLine();
                    if (choix == "Oui") {
                        p.getCases().get(indexCase).acheter(this,sc);
                    }
                } else if (p.getCases().get(indexCase).getProprietaire().equals(this)) {
                    System.out.println("Voulez-vous construire la propriété ?");
                    System.out.println("Oui|Non");
                    String choix = sc.nextLine();
                    if (choix == "Oui") {
                        p.getCases().get(indexCase).construire(this,sc);
                    }
                } else {
                    System.out.println("Le propriétaire de cette case est: "+ p.getCases().get(indexCase).getProprietaire().getNom());
                    int loy = p.getCases().get(indexCase).loyer(this);
                    this.payer(p.getCases().get(indexCase).getProprietaire, loy);
                }
            } else if (p.getCases().get(indexCase) instanceof Taxe) {
                this.payerBanque(p.getCases().get(indexCase).getPrix());
            }
            count += 1;
        }

        }
}
