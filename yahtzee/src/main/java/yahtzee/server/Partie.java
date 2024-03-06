package yahtzee.server;
import java.util.ArrayList;

public class Partie {
    
    private De[] des;
    private ArrayList<Integer> desSelectionnes;

    public Partie(){
        this.des = new De[5];
        this.desSelectionnes = new ArrayList<>();
        for(int i=0; i<5; i++){
            this.des[i] = new De();
        }

    }

    public void run(){
        
    }

    // Lancer tous les dés qui ne sont pas selectionnés
    public void lancerDes(){

    }


}
