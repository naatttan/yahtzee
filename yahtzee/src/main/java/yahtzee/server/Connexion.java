package yahtzee.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connexion extends Remote{

    public Partie_PDU[] demanderVoirParties() throws RemoteException;
    // public 
}
