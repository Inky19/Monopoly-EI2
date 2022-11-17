/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import java.util.List;

import edu.centralenantes.monopoly.ei2.Joueur;

/**
 *
 * @author arthur
 */
public class AllerEnPrison extends Case{
    
    /**
     * Construcuteur de ALlerEnPrison
     * @param i = numéro de la carte
     * @param libelle = nom de carte
     */
    public AllerEnPrison(int i, String libelle) {
        super(i, libelle);
    }

    /**
     * Mets une personne en prison
     * @param j = joueur
     * @param c = liste des cases du plateau
     */
    public void allerPrison(Joueur j, List<Case> c){
        j.setEnPrison(true);
        int indexPrison = 10;
        j.setIndexCase(indexPrison);
    }

}
