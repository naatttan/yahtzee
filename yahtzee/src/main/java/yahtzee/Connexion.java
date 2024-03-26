package yahtzee;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connexion extends java.rmi.Remote{

    public Partie_PDU[] demanderVoirParties() throws RemoteException;
    public int connecterPartie(int idPartie, String nomUser) throws RemoteException;
}
