package yahtzee.client;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class JoueurImpl extends UnicastRemoteObject implements JoueurClient  {

    private PartieClient partie;
    

    public JoueurImpl(int portRMI, PartieClient partie)  throws RemoteException, MalformedURLException{
        super();
        this.partie = partie;
        LocateRegistry.createRegistry(portRMI);
    }

    public ArrayList<Integer> demandeSelectionnerDes() throws RemoteException{

        return
    }

    public boolean demandeLancerDes() throws RemoteException{

        return
    }

    public String demanderEnregistrerFigure() throws RemoteException{

        return
    }

    public void lancerPartie() throws RemoteException{

    }

    public void afficherScore(GrilleJoueur_PDU score_joueur) throws RemoteException{
        this.partie.remplirGrilleJoueur(score_joueur.getJoueur(), score_joueur.getGrille());
    }

    public void afficherDes(int[] des) throws RemoteException{
        this.partie.modifierDes(des);
    }
}