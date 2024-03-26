package yahtzee;

import java.io.Serializable;
import java.util.HashMap;

public class GrilleJoueur_PDU implements Serializable{

    private String nomJoueur;
    private HashMap<String, Integer> grille;

    public GrilleJoueur_PDU(String nomJoueur){
        this.nomJoueur = nomJoueur;
        this.grille = new HashMap<>();
    }

    public void addScoreFigure(String figure, int points){
        this.grille.put(figure, points);
    }

    public HashMap<String, Integer> getGrille(){
        return this.grille;
    }

    public String getJoueur(){
        return this.nomJoueur;
    }
}
