package yahtzee.client;

import java.io.IOException;
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
        System.out.println(this.nomJeu);
    }

    public void affichageDes(){
        int[] des = this.partie.getDes(); 
        String affichage_des = String.format("""
             __      __      __      __      __
            |%d |    |%d |    |%d |    |%d |    |%d |
              
                """, des[0], des[1],des[2],des[3],des[4]); 
        System.out.println(affichage_des);
    }

    public void afficherScores(){
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



}
