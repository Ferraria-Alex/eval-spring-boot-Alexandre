package com.alex.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Produit")
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", nullable = false)
    @NotBlank(message = "Le champ est vide, veuillez le remplir correctement")
    @Size(min = 2)
    private String nom;

    @Column(name="prix", nullable = false)
    @NotBlank(message = "Le champ est vide, veuillez le remplir correctement")
    @Positive(message = "Le nombre doit être un nombre positif supérieur à 0")
    private Double prix;

    
}
