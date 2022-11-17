
package edu.centralenantes.monopoly.ei2.Case.Pioche;

import edu.centralenantes.monopoly.ei2.Joueur;
import edu.centralenantes.monopoly.ei2.NoMoreMoney;

/**
 *
 * @author inky19
 */
public class Communautaire extends PiocherCarte {

    public Communautaire(int num, String nom) {
        super(num, nom);
    }

    public void piocher(Joueur j) throws NoMoreMoney{
            j.payerBanque(50);
    }

}
