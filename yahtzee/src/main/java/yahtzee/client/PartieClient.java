package yahtzee.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import yahtzee.server.De;

public class PartieClient {

    private HashMap<String, HashMap<String, Integer>> grille;
    private int[] des;
    private ArrayList<Integer> desSelectionnes;
    public String affichageOptions;
    

    public PartieClient(String[] nomsJoueurs){
        this.grille = new HashMap<>();
        for(String joueur : nomsJoueurs){
            this.grille.put(joueur, new HashMap<>());
        }
    }

    public String lireStringUser(){
        Scanner scanner = new Scanner(System.in);
        String chaine = scanner.nextLine();
        scanner.close();
        return chaine;
    }

    public void remplirGrilleJoueur(String nomJoueur, HashMap<String, Integer> grilleJoueur){
        for(String figure : grilleJoueur.keySet()){
            this.grille.get(nomJoueur).put(figure, grilleJoueur.get(figure));
        }
    }

    public HashMap<String, HashMap<String, Integer>> getGrille(){
        return this.grille;
    }

    public int[] getDes(){
        return this.des;
    }

    public void demandeSelectionnerDes(){

    }

    public void modifierDes(int[] des){
        this.des = des;
    }

    public ArrayList<Integer> getDesSelectionnes(){
        return this.desSelectionnes;
    }

    public void demandeEnregistrerFigure(){

    }
}
