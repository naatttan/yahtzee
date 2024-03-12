package yahtzee.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ConnexionImpl extends UnicastRemoteObject implements Connexion {
    
    private Server server;

    public ConnexionImpl(Server server) throws RemoteException{
        super();
        this.server = server;
    }

    

}
