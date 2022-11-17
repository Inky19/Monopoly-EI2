/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case.Pioche;

import edu.centralenantes.monopoly.ei2.Case.Case;

/**
 *
 * @author inky19
 */
public class PiocherCarte extends Case{
    private String nom;
    private String description;
    
    
    public PiocherCarte(){
        this.nom = "";
        this.description = "";
    }
    
    public PiocherCarte(String nom, String description){
        this.nom = nom;
        this.description = description;
    }
    
    public PiocherCarte(PiocherCarte carte){
        this.nom = carte.nom;
        this.description = carte.description;
    }

    public String getNomPiocher() {
        return nom;
    }

    public void setNomPiocher(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
