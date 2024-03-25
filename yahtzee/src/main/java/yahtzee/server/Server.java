package yahtzee.server;

import java.util.HashMap;

public class Server {
    
    private HashMap<Integer, Partie> listeParties;
    private HashMap<String, Integer> listeClients;
    // private 

    public Server(){
        this.listeParties = new HashMap<>();
        this.listeClients = new HashMap<>();
    }

    public void ajouterPartie(Partie partie){
        this.listeParties.put(partie.getId(), partie);
    }

    public void ajouterClient(String ipClient, int portRMIClient){
        this.listeClients.put(ipClient, portRMIClient);
    }

    public HashMap<Integer, Partie> getListeParties(){return this.listeParties;}
    public HashMap<String, Integer> getListeClients(){return this.listeClients;}

}
