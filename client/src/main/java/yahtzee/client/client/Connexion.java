package yahtzee.client.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connexion extends Remote{

    public Partie_PDU[] demanderVoirParties() throws RemoteException;
    public int connecterPartie(int idPartie, String nomUser) throws RemoteException;
}