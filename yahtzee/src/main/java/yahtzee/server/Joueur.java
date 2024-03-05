package yahtzee.server;

import java.rmi.RemoteException;
// import utilities.*;

public interface Joueur {

    public void selectionnerDes(Des_PDU des) throws RemoteException;

    // public String[] verifierFigures();
    public void enregistrerFigure(String figure) throws RemoteException;

    public void lancerDes() throws RemoteException;
}
