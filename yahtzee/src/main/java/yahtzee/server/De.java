package yahtzee.server;

import java.util.Random;

public class De {

    private int valeur;
    private Random random;

    public De(){
        this.random = new Random();
        this.valeur = this.random.nextInt(6) + 1;
    }

    public void lancer(){
        this.valeur = this.random.nextInt(6) + 1;
    }

    public int getValeur(){
        return this.valeur;
    }
}
