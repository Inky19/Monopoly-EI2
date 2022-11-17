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

  public Achetable(int num, String nom, int prix, Joueur proprio){ 
    super(num, nom);
    this.prix = prix;
    this.proprietaire = proprio;
  }

  public Achetable(){ 
  }

  public int getPrix() {
    return this.prix;
  }

  public void setPrix(int prix) {
    this.prix = prix;
  }

  public Joueur getProprietaire() {
    return this.proprietaire;
  }

  public void setProprietaire(Joueur proprio) {
    this.proprietaire = proprio;
  }

  public void acheter(Joueur j) {
    try {
      j.payerBanque(this.prix);
      this.setProprietaire(j);
      if (this.getClass().getName().contains("Gare")) {
        j.setNbGares(j.getNbGares() + 1);
      }
    } catch (NoMoreMoney exception) {
      System.out.println("Vous n'avez pas assez d'argent pour acheter la case.");
      System.out.println(" ");
    }
  }

  public abstract int loyer(Joueur j);

}
