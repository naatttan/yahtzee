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
    private Partie partie;
    
    public Joueur(Partie partie, int portRMI){
        this.partie = partie;
    }

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