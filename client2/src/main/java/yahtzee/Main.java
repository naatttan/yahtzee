package yahtzee;

import yahtzee.client.Client;

public class Main {
    public static void main(String[] args) {
        Client c = new Client();
        try {
            c.connectServer();
        } catch (Exception e) {
            System.out.println(e);
        }
        while(!c.exit){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
           
        }
    }
}