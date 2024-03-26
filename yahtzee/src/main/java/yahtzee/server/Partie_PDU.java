package yahtzee.server;

import java.io.Serializable;

public class Partie_PDU implements Serializable{
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
