
package edu.centralenantes.monopoly.ei2.Case.Pioche;

/**
 *
 * @author inky19
 */
public class Communautaire extends PiocherCarte {

    public Communautaire(int num, String nom) {
        super(num, nom);
    }

    public Communautaire(String nom, String description) {
        super(nom, description);
    }

    public Communautaire(PiocherCarte carte) {
        super(carte);
    }

    public Communautaire(int i, String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
