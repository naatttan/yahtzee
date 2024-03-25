package yahtzee.client.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface JoueurClient extends Remote{

    public ArrayList<Integer> demandeSelectionnerDes() throws RemoteException;
    public boolean demandeLancerDes() throws RemoteException;
    public String demanderEnregistrerFigure(List<String> figures) throws RemoteException;

    public void lancerPartie() throws RemoteException;

    public void afficherScore(GrilleJoueur_PDU score_joueur) throws RemoteException;
    public void afficherDes(int[] des) throws RemoteException;
    
}
