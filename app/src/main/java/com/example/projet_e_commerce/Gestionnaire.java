package com.example.projet_e_commerce;

public class Gestionnaire {
    private String pseudo;
    private String mdp;

    public Gestionnaire() {
    }

    public Gestionnaire(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }


    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
