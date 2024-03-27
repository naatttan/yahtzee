package yahtzee.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Grille {

    private HashMap<String, Integer> figures;

    public Grille(){
        this.figures = new HashMap<>();
        this.figures.put("1", 0);
        this.figures.put("2", 0);
        this.figures.put("3", 0);
        this.figures.put("4", 0);
        this.figures.put("5", 0);
        this.figures.put("6", 0);
        this.figures.put("brelan", 0);
        this.figures.put("carre", 0);
        this.figures.put("full", 0);
        this.figures.put("petite suite", 0);
        this.figures.put("grande suite", 0);
        this.figures.put("yahtzee", 0);
        this.figures.put("chance", 0);
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
            case "1":
                return sommeValeursDes(des, 1);
            case "2":
                return sommeValeursDes(des, 2);
            case "3":
                return sommeValeursDes(des, 3);
            case "4":
                return sommeValeursDes(des, 4);
            case "5":
                return sommeValeursDes(des, 5);
            case "6":
                return sommeValeursDes(des, 6);
            case "brelan":
                return sommeDes(des);
            case "carre":
                return sommeDes(des);
            case "full":
                return 25;
            case "petite suite":
                return 30;
            case "grande suite":
                return 40;
            case "yahtzee":
                return 50;
            case "chance":
                return sommeDes(des);
            default:
                return 0;
        }
    }

    public List<String> verifierFigures(int[] des){
        List<String> figures = new ArrayList<>();
        Arrays.sort(des); // Trier les dés pour simplifier la vérification de certaines figures

        if (estYahtzee(des) && this.figures.get("yahtzee") == 0) {
            figures.add("Yahtzee");
        }
        if (estGrandeSuite(des) && this.figures.get("grande suite") == 0) {
            figures.add("Grande Suite");
        }
        if (estPetiteSuite(des) && this.figures.get("petite suite") == 0) {
            figures.add("Petite Suite");
        }
        if (estFull(des) && this.figures.get("full") == 0) {
            figures.add("Full");
        }
        if (estCarré(des) && this.figures.get("carre") == 0) {
            figures.add("Carre");
        }
        if (estBrelan(des) && this.figures.get("brelan") == 0) {
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
            
            if (estDansTableau(i, des) && this.figures.get(String.valueOf(i)) == 0){ 
                figures.add(String.valueOf(i));
            }
        }
    }

    private boolean estDansTableau(int val, int[] tab){
        return Arrays.stream(tab).anyMatch(d -> d == val);
    }

}
