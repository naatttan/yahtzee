package yahtzee.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Grille {

    private HashMap<String, Integer> figures;

    public Grille(){
        this.figures = new HashMap<>();
        this.figures.put("As", 0);
        this.figures.put("Deux", 0);
        this.figures.put("Trois", 0);
        this.figures.put("Quatre", 0);
        this.figures.put("Cinq", 0);
        this.figures.put("Six", 0);
        this.figures.put("Brelan", 0);
        this.figures.put("Carré", 0);
        this.figures.put("Full", 0);
        this.figures.put("Petite Suite", 0);
        this.figures.put("Grande Suite", 0);
        this.figures.put("Yahtzee", 0);
        this.figures.put("Chance", 0);
    }

    public HashMap<String, Integer> getFigures(){return this.figures;}    
    
    public void enregistrerFigure(String figure, int points){
        this.figures.put(figure, points);
    }

    public Boolean grillePleine(){
        for(int fig : this.figures.values()){
            if(fig == 0){return false;}
        }
        return true;
    }

    public void reinitialiserGrille(){
        for(String fig : this.figures.keySet()){
            this.figures.put(fig, 0);
        }
    }

    public Integer compterPointsFigure(int[] des, String figure){
        // Vérifier quelle figure est demandée
        switch (figure) {
            case "As":
                return sommeValeursDes(des, 1);
            case "Deux":
                return sommeValeursDes(des, 2);
            case "Trois":
                return sommeValeursDes(des, 3);
            case "Quatre":
                return sommeValeursDes(des, 4);
            case "Cinq":
                return sommeValeursDes(des, 5);
            case "Six":
                return sommeValeursDes(des, 6);
            case "Brelan":
                return sommeDes(des);
            case "Carré":
                return sommeDes(des);
            case "Full":
                return 25;
            case "Petite Suite":
                return 30;
            case "Grande Suite":
                return 40;
            case "Yahtzee":
                return 50;
            case "Chance":
                return sommeDes(des);
            default:
                return 0;
        }
    }

    public List<String> verifierFigures(int[] des){
        List<String> figures = new ArrayList<>();
        Arrays.sort(des); // Trier les dés pour simplifier la vérification de certaines figures

        if (estYahtzee(des)) {
            figures.add("Yahtzee");
        }
        if (estGrandeSuite(des)) {
            figures.add("Grande Suite");
        }
        if (estPetiteSuite(des)) {
            figures.add("Petite Suite");
        }
        if (estFull(des)) {
            figures.add("Full");
        }
        if (estCarré(des)) {
            figures.add("Carré");
        }
        if (estBrelan(des)) {
            figures.add("Brelan");
        }

        ajouterFiguresNormales(des, figures);

        return figures;
    }

    private int sommeValeursDes(int[] des, int valeur){
        return (int) Arrays.stream(des).filter(d -> d == valeur).count() * valeur;
    }

    private int sommeDes(int[] des){
        int somme = 0;
        for(int i=0; i<5; i++){
            somme += des[i];
        }
        return somme;
    }

    private boolean estYahtzee(int[] des) {
        return des[0] == des[4];
    }

    private boolean estGrandeSuite(int[] des) {
        return (des[0] == 1 && des[1] == 2 && des[2] == 3 && des[3] == 4 && des[4] == 5) ||
            (des[0] == 2 && des[1] == 3 && des[2] == 4 && des[3] == 5 && des[4] == 6);
    }

    private boolean estPetiteSuite(int[] des) {
        return (des[0] == 1 && des[1] == 2 && des[2] == 3 && des[3] == 4) ||
            (des[0] == 2 && des[1] == 3 && des[2] == 4 && des[3] == 5) ||
            (des[0] == 3 && des[1] == 4 && des[2] == 5 && des[3] == 6);
    }

    private boolean estFull(int[] des) {
        return (des[0] == des[1] && des[2] == des[4]) || (des[0] == des[2] && des[3] == des[4]);
    }

    private boolean estCarré(int[] des) {
        return (des[0] == des[3]) || (des[1] == des[4]);
    }

    private boolean estBrelan(int[] des) {
        return (des[0] == des[2]) || (des[1] == des[3]) || (des[2] == des[4]);
    }

    private void ajouterFiguresNormales(int[] des, List<String> figures) {
        for (int i = 1; i <= 6; i++) {
            
            if (estDansTableau(i, des)){ 
                figures.add(String.valueOf(i));
            }
        }
    }

    private boolean estDansTableau(int val, int[] tab){
        return Arrays.stream(tab).anyMatch(d -> d == val);
    }

}
