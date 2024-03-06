package yahtzee.server;

//juste pour tester le dé
public class Main {
    public static void main(String args[])
    {
        De de = new De();
        de.lancer();
        System.out.println("Lancement de dé: " + de.getValeur() );
    }
}