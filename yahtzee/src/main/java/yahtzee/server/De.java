package yahtzee.server;

import java.util.Random;

public class De {
    private int valeur;

    public De() {
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    public void lancer()
    {
        Random random = new Random();
        int de = random.nextInt(6) + 1;
        setValeur(de);
    }
}
