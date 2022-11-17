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

    public AllerEnPrison(int i, String libelle) {
        super(i, libelle);
    }

    public void allerPrison(Joueur j, List<Case> c){
        j.setEnPrison(true);
        int indexPrison = 10;
        j.setIndexCase(indexPrison);
    }

}
