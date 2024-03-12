package yahtzee.client;

import java.util.HashMap;

// class Des_PDU{
//     private int[] des;
//     private int[] desSelectionnes;

//     public Des_PDU(){
//         this.des = new int[5];
//         this.desSelectionnes = new int[5];
//     }

//     public int[] getDes(){
//         return this.des;
//     }

//     public int[] getDesSelectionnes(){
//         return this.desSelectionnes;
//     }
// }

class Partie_PDU{

    private String nomPartie;
    // private int nombreJoueurs;
    private String[] nomsJoueurs;

    public Partie_PDU(String nomPartie, String[] nomsJoueurs){
        this.nomPartie = nomPartie;
        // this.nombreJoueurs = nombreJoueurs;
        this.nomsJoueurs = nomsJoueurs;
    }

    public String getNomPartie(){
        return this.nomPartie;
    }

    // public int getNombreJoueurs(){
    //     return this.nombreJoueurs;
    // }

    public String[] getNomsJoueurs(){
        return this.nomsJoueurs;
    }
}

class GrilleJoueur_PDU{

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