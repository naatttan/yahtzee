package yahtzee;

import yahtzee.server.*;

public class Main {
    public static void main(String[] args) {
        Server s = new Server();
        Partie p1 = new Partie(1, 2);
        Partie p2 = new Partie(2, 3);
        s.ajouterPartie(p1);
        s.ajouterPartie(p2);
        s.lancerParti(p1.getId());
        s.lancerParti(p2.getId());
        s.attendreFinParties();
    }
}