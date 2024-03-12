package yahtzee.client;

import java.util.ArrayList;
import java.util.HashMap;

import yahtzee.server.De;

public class PartieClient {

    private HashMap<String, HashMap<String, Integer>> grille;
    private int[] des;
    private ArrayList<Integer> desSelectionnes;
    

    public PartieClient(String[] nomsJoueurs){
        this.grille = new HashMap<>();
        for(String joueur : nomsJoueurs){
            this.grille.put(joueur, new HashMap<>());
        }
    }

    public void remplirGrilleJoueur(String nomJoueur, HashMap<String, Integer> grilleJoueur){
        for(String figure : grilleJoueur.keySet()){
            this.grille.get(nomJoueur).put(figure, grilleJoueur.get(figure));
        }
    }

    public void modifierDes(int[] des){
        this.des = des;
    }
}
