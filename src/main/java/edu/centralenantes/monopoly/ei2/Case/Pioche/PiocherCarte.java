/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case.Pioche;

import edu.centralenantes.monopoly.ei2.Joueur;
import edu.centralenantes.monopoly.ei2.NoMoreMoney;
import edu.centralenantes.monopoly.ei2.Case.Case;

/**
 *
 * @author inky19
 */
public abstract class PiocherCarte extends Case{    
    
    public PiocherCarte(int num, String nom){
        super(num, nom);
    }

    public abstract void piocher(Joueur j) throws NoMoreMoney;
    
}
