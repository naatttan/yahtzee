package yahtzee.server;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Random;

import yahtzee.Connexion;


public class ConnexionImpl extends UnicastRemoteObject implements Connexion {
    
    private Server server;

    public ConnexionImpl(Server server) throws RemoteException{
        super();
        this.server = server;
    }

    public Partie_PDU[] demanderVoirParties() throws RemoteException{
        HashMap<Integer, Partie> listePartie = this.server.getListeParties();
        Partie_PDU[] listPartie_PDUs = new Partie_PDU[listePartie.values().size()];
        int i = 0;
        for(Partie partie : listePartie.values()){
            String[] noms = new String[partie.getJoueurs().size()];
            for(int j = 0; j<partie.getNombreJoueurs(); j++){
                noms[j] = partie.getJoueurs().get(j).getNom();
            }
            listPartie_PDUs[i] = new Partie_PDU(partie.getId(), noms);
            i++;
        }
        return listPartie_PDUs;
    }

    public int connecterPartie(int idPartie, String nomUser) throws RemoteException{
        int rmiPort;
        Random random = new Random();
        String ipClient = "localhost";
        try {
            ipClient = RemoteServer.getClientHost();
        } catch (Exception e) {
            System.out.println("Erreur connection: " + e);
        }
        rmiPort = random.nextInt(4001 - 2000) + 2000;
        while(this.server.getListeClients().containsValue(rmiPort)){
            rmiPort = random.nextInt(4001 - 2000) + 2000;
        }
        this.server.getListeClients().put(ipClient, rmiPort);
        Joueur joueur = new Joueur(ipClient, rmiPort, nomUser);
        this.server.getListeParties().get(idPartie).addJoueur(joueur);
        System.out.println(String.format("%s connecté -> %s rmi:%d", nomUser, ipClient, rmiPort));
        return rmiPort;
    }

}
