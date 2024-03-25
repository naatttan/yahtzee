package yahtzee.client.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Affichage {
    
    private Client client;
    private PartieClient partie;
    private String nomJeu = """
        __ __   ____  __ __  ______  _____    ___    ___ 
        |  |  | /    ||  |  ||      ||     |  /  _]  /  _]
        |  |  ||  o  ||  |  ||      ||__/  | /  [_  /  [_ 
        |  ~  ||     ||  _  ||_|  |_||   __||    _]|    _]
        |___, ||  _  ||  |  |  |  |  |  /  ||   [_ |   [_ 
        |     ||  |  ||  |  |  |  |  |     ||     ||     |
        |____/ |__|__||__|__|  |__|  |_____||_____||_____|
                                                               
            """;

    public Affichage(Client client){
        this.client = client;
    }

    public void afficherPartiesDispo(Partie_PDU[] parties){
        String partiesDispo = "Choisissez une partie: \n";
        this.effacerConsole();
        this.affichageTitre();
        for(int i = 0; i<parties.length; i++){
            partiesDispo += String.format("%d) %s (%d joueurs) \n", i+1, parties[i].getNomPartie(), parties[i].getNombreJoueurs());
        }
        System.out.println(partiesDispo);
    }

    private void effacerConsole(){
        try{
            Process clear = new ProcessBuilder("clear").start();
            clear.waitFor();
        }catch(IOException | InterruptedException e){
            System.out.println(e);
        }
    }

    public void setPartie(PartieClient partie){
        this.partie = partie;
    }

    public void affichageTitre(){
        this.effacerConsole();
        System.out.println(this.nomJeu);
    }

    private void affichageDes(){
        int[] des = this.partie.getDes(); 
        String affichage_des = String.format("""
             __      __      __      __      __
            |%d |    |%d |    |%d |    |%d |    |%d |
              
                """, des[0], des[1],des[2],des[3],des[4]); 
        System.out.println(affichage_des);
    }

    private void afficherScores(){
        HashMap<String, HashMap<String, Integer>> grille = this.partie.getGrille();
        System.out.println("|1       |2       |3       |4       |5       |6       |Brelan  |Carre   |Full    |PS      |GS      |Yahtzee |Chance  |");
        for(String joueur : grille.keySet()){
            System.out.println(this.valeursScoreJoueur(grille.get(joueur)) + joueur);
        }
    }

    private String valeursScoreJoueur(HashMap<String, Integer> scoreJoueur){
        String score = "";
        for(int i : scoreJoueur.values()){
            String nb = Integer.toString(i);
            score += "|" + nb + " ".repeat(8 - nb.length());
        }
        score += "|";
        return score;
    }

    private void afficherOptions(){
        System.out.println(this.partie.affichageOptions);
    }

    private void affichageDesSelectionnes(){
        ArrayList<Integer> selections = this.partie.getDesSelectionnes();
        Collections.sort(selections);
        String affichage = "Dés sélectionnés: ";
        for(int i : selections){
            affichage += i + ",";
        }
        System.out.println(affichage.substring(0, affichage.length()-2));
    }

    public void affichagePartie(){
        this.effacerConsole();
        this.affichageDes();
        this.afficherScores();
        this.affichageDesSelectionnes();
        this.afficherOptions();
    }

}
