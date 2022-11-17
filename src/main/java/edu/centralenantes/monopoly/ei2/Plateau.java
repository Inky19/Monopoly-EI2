/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

import java.util.LinkedList;
import java.util.List;

import edu.centralenantes.monopoly.ei2.Case.Case;
/**
 *
 * @author inky19
 */
public class Plateau {
    List<Case> cases;
    List<Joueur> joueurs;

    public Plateau() {
        this("/plateau/plateau.txt");
    }

    public Plateau (String path) {
        cases = new LinkedList<>();
        joueurs = new LinkedList<>();
        initPlateau(path);
    }

    private void initPlateau(String path) {

    }

}
