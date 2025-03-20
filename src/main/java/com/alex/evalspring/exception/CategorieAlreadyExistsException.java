package com.alex.evalspring.exception;

public class CategorieAlreadyExistsException extends RuntimeException {
    public CategorieAlreadyExistsException(String libelle) {
        super("Une categorie avec la libelle : (" + libelle + ") existe deja!");
    }
}
