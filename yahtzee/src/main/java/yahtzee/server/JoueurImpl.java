package yahtzee.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JoueurImpl extends UnicastRemoteObject implements Joueur {
    
    
    public JoueurImpl() throws RemoteException {
        super();
        
    }

    public void selectionnerDes(Des_PDU des) throws RemoteException {

    }

    // public String[] verifierFigures();
    public void enregistrerFigure(String figure) throws RemoteException {

    }

    public void lancerDes() throws RemoteException {

    }
}
