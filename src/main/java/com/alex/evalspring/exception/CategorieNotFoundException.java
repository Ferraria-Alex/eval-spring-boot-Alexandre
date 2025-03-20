package com.alex.evalspring.exception;

public class CategorieNotFoundException extends RuntimeException {
    public CategorieNotFoundException(Long id) {
        super("La categorie avec l'id (" + id + ") n'existe pas");
    }
}
