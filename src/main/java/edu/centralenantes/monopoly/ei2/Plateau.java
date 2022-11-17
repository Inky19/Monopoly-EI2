/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import edu.centralenantes.monopoly.ei2.Case.AllerEnPrison;
import edu.centralenantes.monopoly.ei2.Case.Case;
import edu.centralenantes.monopoly.ei2.Case.Compagnie;
import edu.centralenantes.monopoly.ei2.Case.Constructible;
import edu.centralenantes.monopoly.ei2.Case.Gare;
import edu.centralenantes.monopoly.ei2.Case.Inutile;
import edu.centralenantes.monopoly.ei2.Case.Prison;
import edu.centralenantes.monopoly.ei2.Case.Taxe;
import edu.centralenantes.monopoly.ei2.Case.Pioche.Chance;
import edu.centralenantes.monopoly.ei2.Case.Pioche.Communautaire;

import java.util.Scanner;


/**
 *
 * @author inky19, littlewuuu, Bryan
 */
public class Plateau {
    List<Case> cases;
    List<Joueur> joueurs;

    public Plateau() {
        this("/plateau/plateau.txt");
    }

    public Plateau(String path) {
        cases = new LinkedList<>();
        joueurs = new LinkedList<>();
        initPlateau(path);
    }

    private void initPlateau(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = br.readLine();
            String values[] = line.split("_");
            int nbCases = Integer.parseInt(values[0]);

            String libelle = null;
            int prix;
            String typeCase = null;

            for (int i = 0; i < nbCases; i++) {
                Case c;
                Joueur j = null;
                line = br.readLine();
                values = line.split("_");
                libelle = values[0];
                prix = Integer.parseInt(values[1]);
                typeCase = values[1];
                switch (typeCase) {
                    case "0":
                        c = new Constructible(i,libelle,prix);
                        break;
                    case "1":
                        c = new Gare(i,libelle,prix,null);
                        break;
                    case "2":
                        c = new Taxe(i,libelle,prix);
                        break;
                    case "3":
                        c = new Communautaire(i,libelle):
                        break;
                    case "4":
                        c = new Chance(i,libelle);
                        break;
                    case "5":
                        c = new Inutile(i,libelle);
                        break;
                    case "6":
                        c = new Prison(i,libelle);
                        break;
                    case "7":
                        c = new Compagnie(i, libelle, prix);
                        break;
                    case "8":
                        c = new AllerEnPrison(i,libelle);
                        break;
                    default:
                        System.out.println("Problèmem : " + typeCase + " ne correspond à rien.");
                }
                cases.add(c);
            }

        } catch (NumberFormatException e) {
            System.out.println("Problème avec la convertion d'un string en int");
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void affiche() {
        for (Case c : cases) {
            System.out.println(c);
        }
    }
    
    private void initJoueur(){
        int nbJoueur;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de Joueur");
        nbJoueur = scanner.nextInt();
        for (int i=0;i<nbJoueur;i++){
            Joueurs.add(new Joueur());
        }
    }
    
    public void tourDeJeu(){
        for (Joueur j : Joueurs){
            j.tourDuJoueur(this);
        }
    }

    public List<Case> getCases() {
        return this.cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public List<Joueur> getJoueurs() {
        return this.joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}