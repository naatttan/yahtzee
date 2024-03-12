package yahtzee.server;


// class Des_PDU{
//     private int[] des;
//     private int[] desSelectionnes;

//     public Des_PDU(){
//         this.des = new int[5];
//         this.desSelectionnes = new int[5];
//     }

//     public int[] getDes(){
//         return this.des;
//     }

//     public int[] getDesSelectionnes(){
//         return this.desSelectionnes;
//     }
// }

class Partie_PDU{

    private String nomPartie;
    private int nombreJoueurs;

    public Partie_PDU(String nomPartie, int nombreJoueurs){
        this.nomPartie = nomPartie;
        this.nombreJoueurs = nombreJoueurs;
    }

    public String getNomPartie(){
        return this.nomPartie;
    }

    public int getNombreJoueurs(){
        return this.nombreJoueurs;
    }
}