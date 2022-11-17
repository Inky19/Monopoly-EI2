/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import edu.centralenantes.monopoly.ei2.Joueur;

/**
 *
 * @author Tristan
 */
public class Gare extends Achetable {

    public Gare(int num, String nom, int prix, Joueur proprietaire) {
        super(num, nom, prix, proprietaire);
    }

    public String toString() {
        String retour = this.getNom() + "(coût : " + this.getPrix() + " € ) - ";
        if (this.getProprietaire() == null) {
            retour = retour + "sans propriétaire";
        } else {
            retour = retour + "propriétaire" + this.getProprietaire().getNom() + ", "
                    + this.getProprietaire().getNbGare()
                    + ", loyer = " + this.loyer() + "€";
        }
        return retour;
    }

    @Override
    public int loyer() {
        return 2500 * this.getProprietaire().getNbGare();
    }

}
