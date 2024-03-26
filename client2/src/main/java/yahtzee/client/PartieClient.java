package yahtzee.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PartieClient {

    private HashMap<String, HashMap<String, Integer>> grille;
    private int[] des;
    private ArrayList<Integer> desSelectionnes;
    public String affichageOptions;
    private Client client;
    

    public PartieClient(Client client, String[] nomsJoueurs){
        this.client = client;
        this.client.getAffichage().setPartie(this);
        this.grille = new HashMap<>();
        for(String joueur : nomsJoueurs){
            this.grille.put(joueur, new HashMap<>());
        }
    }

    public void actualiserAffichage(){
        this.client.getAffichage().affichagePartie();
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
        this.affichageOptions = """
            Quels dés voulez vous sélectionner ? (1, 2, 3, 4, 5). 
            Ecrivez 'OK' lorsque votre choix est fait.
                """;
        this.client.getAffichage().affichagePartie();
        String clientString = this.client.lireStringUser();
        while(!clientString.equalsIgnoreCase("ok")){
            switch (clientString.toLowerCase()) {
                case "1":
                    this.desSelectionnes.add(1);
                    break;                    
                case "2":
                    this.desSelectionnes.add(2);
                    break;                   
                case "3":
                    this.desSelectionnes.add(3);
                    break;
                case "4":
                    this.desSelectionnes.add(4);
                    break;
                case "5":
                    this.desSelectionnes.add(5);
                    break;
                case "ok":
                    break;
            
                default:
                    System.out.println("Ce choix ne fait pas parti des options.");
                    break;
            }
        }        
    }

    public void modifierDes(int[] des){
        this.des = des;
    }

    public ArrayList<Integer> getDesSelectionnes(){
        return this.desSelectionnes;
    }

    public String demandeEnregistrerFigure(List<String> figures){
        String options = "Quelle figure voulez vous enregistrer ?\n";
        for(int i = 1; i<=figures.size(); i++){
            options += i + "- " + figures.get(i-1);
        }
        this.affichageOptions = options;
        this.client.getAffichage().affichagePartie();
        int valeurFigure = 0;
        while(!(valeurFigure <= figures.size() && valeurFigure > 0)){
            String stringUser = this.client.lireStringUser();
            try {
                valeurFigure = Integer.parseInt(stringUser);
            } catch (Exception e) {
                System.out.println("Entrez une valeur numérique.");
            }
        }
        return figures.get(valeurFigure-1);
    }
  
}
