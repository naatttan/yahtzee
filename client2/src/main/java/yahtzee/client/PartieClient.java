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
        this.desSelectionnes = new ArrayList<>();
        for(String joueur : nomsJoueurs){
            this.grille.put(joueur, new HashMap<>());
        }
    }


    public void setDesSelectionnes(ArrayList<Integer> selection){
        this.desSelectionnes.clear();
        for(int i : selection)
            this.desSelectionnes.add(i);
    }

    public void actualiserAffichage(){
        this.affichageOptions = "";
        this.client.getAffichage().affichagePartie();
    }

    public void remplirGrilleJoueur(String nomJoueur, HashMap<String, Integer> grilleJoueur){
        if(!this.grille.containsKey(nomJoueur)){
            this.grille.put(nomJoueur, new HashMap<>());
        }
        this.grille.get(nomJoueur).clear();
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

    public ArrayList<Integer> demandeSelectionnerDes(){
        ArrayList<Integer> liste = this.desSelectionnes;
        this.affichageOptions = """
            Quels dés voulez vous sélectionner ? (1, 2, 3, 4, 5). 
            Ecrivez 'OK' lorsque votre choix est fait.
                """;
        this.client.getAffichage().affichagePartie();
        String clientString = "";
        while(!clientString.equalsIgnoreCase("ok")){
            clientString = this.client.lireStringUser();
            switch (clientString.toLowerCase()) {
                case "1":
                    if(!liste.contains(1)){
                        liste.add(1);
                    }else{
                        liste.remove(liste.indexOf(1));
                    }
                         
                    break;                    
                case "2":
                    if(!liste.contains(2)){
                        liste.add(2);
                    }else{
                        liste.remove(liste.indexOf(2));
                    }
                    break;                   
                case "3":
                    if(!liste.contains(3)){
                        liste.add(3);
                    }else{
                        liste.remove(liste.indexOf(3));
                    }
                    break;
                case "4":
                    if(!liste.contains(4)){
                        liste.add(4);
                    }else{
                        liste.remove(liste.indexOf(4));
                    }
                    break;
                case "5":
                    if(!liste.contains(5)){
                        liste.add(5);
                    }else{
                        liste.remove(liste.indexOf(5));
                    }
                    break;
                case "ok":
                    break;
            
                default:
                    System.out.println("Ce choix ne fait pas parti des options.");
                    break;
            }
        } 
        return liste;       
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
            options += i + "- " + figures.get(i-1) + "\n";
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
