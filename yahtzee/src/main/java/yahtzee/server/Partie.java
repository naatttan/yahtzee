package yahtzee.server;
import java.util.ArrayList;

public class Partie {
    
    private int idPartie;
    private De[] des;
    private ArrayList<Integer> desSelectionnes;
    private boolean partieEnCours;
    private ArrayList<Joueur> joueurs;
    private int nomreJoueur;

    public Partie(int idPartie, int nomreJoueur){
        this.idPartie = idPartie;
        this.des = new De[5];
        this.desSelectionnes = new ArrayList<>();
        for(int i=0; i<5; i++){
            this.des[i] = new De();
        }
        this.nomreJoueur = nomreJoueur;
        this.joueurs = new ArrayList<Joueur>();
        this.partieEnCours = false;
    }

    public int getId(){return this.idPartie;}
    public int getNombreJoueurs(){return this.joueurs.size();}
    public ArrayList<Joueur> getJoueurs(){return this.joueurs;}

    public void addJoueur(Joueur joueur){
        if(!this.partieEnCours && (this.joueurs.size() < this.nomreJoueur)){
            this.joueurs.add(joueur);

        }
    }

    public void run(){
        int timer = 0;
        while(!(this.joueurs.size() > 1 && timer >= 30) || this.joueurs.size() < this.nomreJoueur){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                
            }
            timer++;
        }
        this.partieEnCours = true;
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
