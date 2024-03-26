package yahtzee.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import yahtzee.Connexion;
import yahtzee.Partie_PDU;
import yahtzee.*;

public class Client {
    
    private final String ipServer = "localhost";
    private final int portServer = 1099;

    private final String IP_CLIENT = "localhost";
    private String urlServer;
    private Affichage affichage;
    private PartieClient partie;
    private JoueurClient joueur;
    private Scanner scanner;
    public boolean exit;

    public Client(){
        this.urlServer = "rmi://" + this.ipServer + ":" + this.portServer + "/";
        this.affichage = new Affichage(this);
        this.exit = false;
        this.scanner = new Scanner(System.in);
    }

    public Affichage getAffichage(){
        return this.affichage;
    }

    public JoueurClient getJoueur(){return this.joueur;}

    public String lireStringUser(){
        // Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String chaine = this.scanner.nextLine();
        // scanner.close();
        if(chaine.equalsIgnoreCase("exit")){this.exit = true;}
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
        int portRMI = (Integer) conn.connecterPartie(parties[valeurPartie-1].getNomPartie(), nomUser);
        LocateRegistry.createRegistry(portRMI);
        this.partie = new PartieClient(this, parties[valeurPartie-1].getNomsJoueurs());
        this.joueur = new JoueurImpl(portRMI, this.partie);
        Naming.rebind("rmi://"+this.IP_CLIENT+":"+ portRMI +"/joueur", conn);
        System.out.println("RMI: " + portRMI);
    }

}
