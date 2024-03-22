package yahtzee.client;

public class Client {
    
    private final String ipServer = "localhost";
    private final int portServer = 1099;
    private String urlServer;

    public Client(){
        this.urlServer = "rmi://" + this.ipServer + ":" + this.portServer + "/";
        
    }

    public void connectServer(){

    }

}
