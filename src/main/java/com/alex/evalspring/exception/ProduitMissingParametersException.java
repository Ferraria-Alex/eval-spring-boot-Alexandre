package com.alex.evalspring.exception;

import com.alex.evalspring.model.Produit;

public class ProduitMissingParametersException extends RuntimeException {
    public ProduitMissingParametersException(Produit produit) {
        super("Le nouvelle produit n'est pas valide : Paramètres mal saisis. \n Nom : " + produit.getNom() + " \n Prix : " + produit.getPrix());
    }
}
