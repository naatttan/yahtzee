package yahtzee.server;
import java.util.ArrayList;

public class Partie implements Runnable{
    
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
    public ArrayList<Integer> getDesSelectionnes(){return this.desSelectionnes;}
    public De[] getDes(){return this.des;}
    public int[] getValeursDes() {
        int[] vals = new int[this.des.length];
        for(int i=0; i<this.des.length; i++){vals[i] = this.des[i].getValeur();}
        return vals; 
    }


    public void addJoueur(Joueur joueur){
        if(!this.partieEnCours && (this.joueurs.size() < this.nomreJoueur)){
            this.joueurs.add(joueur);
            joueur.setPartie(this);
        }
    }

    public void run(){
        int timer = 0;
        System.out.println(String.format("Partie %d running...", this.idPartie));
        while((this.joueurs.size() < this.nomreJoueur) && (!(this.joueurs.size() > 0 && timer >= 30))){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                
            }
            System.out.print("*");
            timer++;
        }
        this.partieEnCours = true;
        this.initialiserPartie();
        while(partieEnCours){
            for(Joueur joueur : this.joueurs){
                int nbLance = 0;
                while(desSelectionnes.size() < 5 && nbLance < 3){
                    System.out.println("au tour de " + joueur.getNom());
                    joueur.lancerDes();
                    for(Joueur j : this.joueurs){
                        j.afficherDes();
                        if(j != joueur){j.actualiserAffichage();}
                    }
                    joueur.selectionnerDes();
                    nbLance++;
                }
                for(Joueur j : this.joueurs){
                    j.actualiserAffichage();
                }
            }
        }
    }

    public void initialiserPartie(){
        for(Joueur j : this.joueurs){
            j.connectionRMI();
            for(Joueur j1 : this.joueurs){
                j.afficherScore(j1);
            }
            j.afficherDes();
            j.actualiserAffichage();
        }
    }

    // Lancer tous les dés qui ne sont pas selectionnés
    public void lancerDes(){
        for(int i=0; i<this.des.length; i++){
            if(!this.desSelectionnes.contains(i+1)){
                this.des[i].lancer();
            }
        }
    }

    // public void selectionnerDes(ArrayList<Integer> numDes){
    //     for(int num : numDes){
    //         this.desSelectionnes.add(num);
    //     }
    // }
}
