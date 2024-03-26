package yahtzee.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {
    
    private final String ipServer = "localhost";
    private final int portServer = 1099;
    private String urlServer;
    private Affichage affichage;
    private PartieClient partie;
    private JoueurClient joueur;

    public Client(){
        this.urlServer = "rmi://" + this.ipServer + ":" + this.portServer + "/";
        this.affichage = new Affichage(this);
    }

    public Affichage getAffichage(){
        return this.affichage;
    }

    public String lireStringUser(){
        Scanner scanner = new Scanner(System.in);
        String chaine = scanner.nextLine();
        scanner.close();
        return chaine;
    }

    public void connectServer() throws MalformedURLException, RemoteException, NotBoundException{
        Connexion conn = (Connexion) Naming.lookup(this.urlServer + "connexion");
        Partie_PDU[] parties = conn.demanderVoirParties();
        this.affichage.afficherPartiesDispo(parties);
        int valeurPartie = 0;
        while(!(valeurPartie <= parties.length && valeurPartie > 0)){
            String userString = this.lireStringUser();
            try {
                valeurPartie = Integer.parseInt(userString);
            } catch (Exception e) {
                System.out.println("Entrez une valeur numérique.");
            }
        }
        System.out.println("Entrez votre nom: ");
        String nomUser = this.lireStringUser();
        int portRMI = conn.connecterPartie(parties[valeurPartie-1].getNomPartie(), nomUser);
        LocateRegistry.createRegistry(portRMI);
        this.partie = new PartieClient(this, parties[valeurPartie-1].getNomsJoueurs());
        this.joueur = new JoueurImpl(portRMI, this.partie);
    }

}
