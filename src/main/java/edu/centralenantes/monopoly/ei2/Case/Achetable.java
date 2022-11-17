/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

/**
 *
 * @author inky19
 */
public abstract class Achetable extends Case {
  private int prix;
  private Joueur proprietaire;
  
  public void Achetable(int num, String nom, int prix, Joueur proprio){
    super(num, nom);
    this.prix = prix;
    this.proprietaire = proprio;
  }
  
  public void Achetable(){
  }
  
  public int getPrix(){
    return this.prix;
  }
  
  public void setPrix(int prix){
    this.prix = prix;
  }
  
  public Joueur getProprietaire(){
    return this.proprietaire;
  }
  
  public void setProprietaire(Joueur proprio){
    this.proprietaire = proprio;
  }
  
  public void acheter(Joueur j){
    
    this.setProprietaire(j);
    j.setFortune( j.getFortune() - this.prix );
  }
  
  public abstract int loyer(Joueur j);
  
}
