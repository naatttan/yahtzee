package yahtzee.server;
import java.util.ArrayList;

public class Partie {
    
    private De[] des;
    private ArrayList<Integer> desSelectionnes;
    private boolean partieEnCours;
    private Joueur[] joueurs;

    public Partie(int nomreJoueur){
        this.des = new De[5];
        this.desSelectionnes = new ArrayList<>();
        for(int i=0; i<5; i++){
            this.des[i] = new De();
        }
        this.joueurs = new Joueur[nomreJoueur];
    }

    public void run(){
        while(partieEnCours){
            for(Joueur joueur : this.joueurs){
                while(! (desSelectionnes.size() < 5)){
                    joueur.lancerDes();
                    joueur.selectionnerDes();
                }
            }
        }
    }

    // Lancer tous les dés qui ne sont pas selectionnés
    public void lancerDes(){
        for(int i=0; i<this.des.length; i++){
            if(this.desSelectionnes.contains(i)){
                this.des[i].lancer();
            }
        }
    }

    public void selectionnerDes(ArrayList<Integer> numDes){
        for(int num : numDes){
            this.desSelectionnes.add(num);
        }
    }


}
