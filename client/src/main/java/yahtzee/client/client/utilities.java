package yahtzee.client.client;

import java.io.Serializable;
import java.util.HashMap;


class Partie_PDU implements Serializable{
    private int idPartie;
    private String[] nomsJoueurs;


    public Partie_PDU(int idPartie, String[] nomsJoueurs){
        this.idPartie = idPartie;
        this.nomsJoueurs = nomsJoueurs;
    }

    public int getNomPartie(){return this.idPartie;}
    public String[] getNomsJoueurs(){return this.nomsJoueurs;}
    public int getNombreJoueurs(){return this.nomsJoueurs.length;}
}

class GrilleJoueur_PDU implements Serializable{

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