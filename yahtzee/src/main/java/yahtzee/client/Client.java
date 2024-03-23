package yahtzee.client;

public class Client {
    
    private final String ipServer = "localhost";
    private final int portServer = 1099;
    private String urlServer;
    private Affichage affichage;

    public Client(){
        this.urlServer = "rmi://" + this.ipServer + ":" + this.portServer + "/";
        this.affichage = new Affichage(this);
    }

    public Affichage getAffichage(){
        return this.affichage;
    }

    public void connectServer(){

    }

}
