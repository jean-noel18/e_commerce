package com.example.projet_e_commerce;

public class Client {

    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;
    private String addresse;
    private String centreInteret;

    public Client() {
    }

    public Client(String nom, String prenom, String pseudo, String mdp, String addresse, String centreInteret) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.addresse = addresse;
        this.centreInteret = centreInteret;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getCentreInteret() {
        return centreInteret;
    }

    public void setCentreInteret(String centreInteret) {
        this.centreInteret = centreInteret;
    }
}
