package yahtzee.client.client;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class JoueurImpl extends UnicastRemoteObject implements JoueurClient  {

    private PartieClient partie;
    

    public JoueurImpl(int portRMI, PartieClient partie)  throws RemoteException, MalformedURLException{
        super();
        this.partie = partie;
        // LocateRegistry.createRegistry(portRMI);
    }

    public ArrayList<Integer> demandeSelectionnerDes() throws RemoteException{
        this.partie.demandeSelectionnerDes();
        return this.partie.getDesSelectionnes();
    }

    public boolean demandeLancerDes() throws RemoteException{
        
        return false;
    }

    public String demanderEnregistrerFigure(List<String> figures) throws RemoteException{
        return this.partie.demandeEnregistrerFigure(figures);
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
