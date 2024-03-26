package yahtzee;

import java.rmi.Remote;
import java.rmi.RemoteException;

import yahtzee.server.Partie_PDU;

public interface Connexion extends Remote{

    public Partie_PDU[] demanderVoirParties() throws RemoteException;
    public int connecterPartie(int idPartie, String nomUser) throws RemoteException;
}
