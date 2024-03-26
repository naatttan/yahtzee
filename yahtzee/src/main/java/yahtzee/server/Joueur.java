package yahtzee.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;
import yahtzee.*;
// import utilities.*;

// public interface Joueur {

//     public void selectionnerDes(Des_PDU des) throws RemoteException;

//     // public String[] verifierFigures();
//     public void enregistrerFigure(String figure) throws RemoteException;

//     public void lancerDes() throws RemoteException;
// }

public class Joueur{
    private String nom;
    private Partie partie;
    private String adresseIP;
    private int portRMI;
    private String urlClient;
    private JoueurClient joueurRMI;
    private Grille grille;
    
    public Joueur(String adresseIP, int portRMI, String nomJoueur){
        this.adresseIP = adresseIP;
        this.portRMI = portRMI;
        this.nom = nomJoueur;
        this.grille = new Grille();
    }

    public void setPartie(Partie partie){this.partie = partie;}

    public String getNom(){return this.nom;}
    public Grille getGrille(){return this.grille;}
    // public De[] getDes(){

    // }
    
    public void connectionRMI(){
        this.urlClient = "rmi://" + this.adresseIP + ":" + this.portRMI + "/";
        try {
            this.joueurRMI = (JoueurClient) Naming.lookup(urlClient + "joueur");
            System.out.println(this.getNom() + " connecté RMI.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectionnerDes(){
        try {
            ArrayList<Integer> selection = this.joueurRMI.demandeSelectionnerDes();
            System.out.println("Retour " + selection.size());
            for(int i : selection){
                if(!this.partie.getDesSelectionnes().contains(i)){
                    this.partie.getDesSelectionnes().add(i);
                }else{
                    this.partie.getDesSelectionnes().remove(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public void afficherDes(){
        try {
            this.joueurRMI.afficherDes(this.partie.getValeursDes());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void enregistrerFigure(){
        try {
            String fig = this.joueurRMI.demanderEnregistrerFigure(this.grille.verifierFigures(this.partie.getValeursDes()));
            this.grille.enregistrerFigure(fig, this.grille.compterPointsFigure(this.partie.getValeursDes(), fig));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lancerDes(){
        this.partie.lancerDes();
    }

    public void actualiserAffichage(){
        try {
            this.joueurRMI.actualiserAffichage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afficherScore(Joueur joueur){
        try {
            GrilleJoueur_PDU grille_pdu = new GrilleJoueur_PDU(joueur.getNom());
            for(String fig : joueur.getGrille().getFigures().keySet()){
                grille_pdu.addScoreFigure(fig, joueur.getGrille().getFigures().get(fig));
            }
            joueurRMI.afficherScore(grille_pdu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}