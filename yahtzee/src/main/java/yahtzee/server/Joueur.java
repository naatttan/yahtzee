package yahtzee.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
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
    
    public Joueur(String adresseIP, int portRMI, String nomJoueur){
        this.adresseIP = adresseIP;
        this.portRMI = portRMI;
        this.nom = nomJoueur;
        this.urlClient = "rmi://" + this.adresseIP + ":" + this.portRMI + "/";
    }

    public void setPartie(Partie partie){this.partie = partie;}

    public String getNom(){return this.nom;}
    // public De[] getDes(){

    // }



    public void selectionnerDes(){
        this.partie.lancerDes();
    }

    // public String[] verifierFigures();
    public void enregistrerFigure(String figure){

    }

    public void lancerDes(){

    }
}