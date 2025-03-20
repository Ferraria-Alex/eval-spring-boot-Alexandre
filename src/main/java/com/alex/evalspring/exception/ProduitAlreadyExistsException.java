package com.alex.evalspring.exception;

public class ProduitAlreadyExistsException extends RuntimeException {
    public ProduitAlreadyExistsException(String nom) {
        super("Un produit avec le nom : (" + nom + ") existe deja!");
    }
}
