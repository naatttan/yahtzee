package yahtzee;

import yahtzee.server.*;

public class Main {
    public static void main(String[] args) {
        Server s = new Server();
        Partie p1 = new Partie(1, 1);
        s.ajouterPartie(p1);
        s.lancerParti(p1.getId());
        s.attendreFinParties();
    }
}