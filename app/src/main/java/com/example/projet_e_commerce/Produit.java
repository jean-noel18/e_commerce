package com.example.projet_e_commerce;

public class Produit {

    private String categorie;
    private String nom;
    private String prix;
    private String description;
    private String promo;

    public Produit() {
    }

    public Produit(String categorie, String nom, String prix, String description, String promo) {
        this.categorie = categorie;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.promo = promo;
    }


    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }
}
