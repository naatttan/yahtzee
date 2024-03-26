package yahtzee.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import yahtzee.ConnexionImpl;

public class Server {

    private final int PORT_RMI = 1099;
    private final String ADRESSE_IP = "localhost";
    private final String URL_SERVER = "rmi://" + this.ADRESSE_IP + ":" + this.PORT_RMI + "/";
    
    private HashMap<Integer, Partie> listeParties;
    private HashMap<String, Integer> listeClients;
    private HashMap<Integer, Thread> threadsParties;
    private ConnexionImpl connexion;


    // private 

    public Server(){
        this.listeParties = new HashMap<>();
        this.listeClients = new HashMap<>();
        this.threadsParties = new HashMap<>();
        try {
            this.connexion = new ConnexionImpl(this);
            LocateRegistry.createRegistry(PORT_RMI);
            Naming.rebind(URL_SERVER + "connexion", this.connexion);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ajouterPartie(Partie partie){
        this.listeParties.put(partie.getId(), partie);
        this.threadsParties.put(partie.getId(), new Thread(partie));
    }

    public void lancerParti(int idPartie){
        this.threadsParties.get(idPartie).start();
    }

    public void attendreFinParties(){
        for(Thread t : this.threadsParties.values()){
            try {
                t.join();
            } catch (Exception e) {
                System.out.println(e);
            }        
        }
        System.out.println("Toutes les parties terminées");
    }

    public void ajouterClient(String ipClient, int portRMIClient){
        this.listeClients.put(ipClient, portRMIClient);
    }

    public HashMap<Integer, Partie> getListeParties(){return this.listeParties;}
    public HashMap<String, Integer> getListeClients(){return this.listeClients;}

}
