package com.alex.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Produit")
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", nullable = false)
    @NotBlank(message = "Le champ est vide, veuillez le remplir correctement")
    @Size(min = 2, message = "Le champ doit avoir plus de 2 characteres")
    private String nom;

    @Column(name="prix", nullable = false)
    @NotNull(message = "Le champ est vide, veuillez le remplir correctement")
    @Positive(message = "Le nombre doit être un nombre positif supérieur à 0")
    private Double prix;

    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Categorie categorie;

    public Produit() {}

    public Produit(String nom, Double prix, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", categorie=" + categorie.toString() +
                '}';
    }
}
