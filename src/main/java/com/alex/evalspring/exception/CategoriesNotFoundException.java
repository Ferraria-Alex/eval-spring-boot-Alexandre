package com.alex.evalspring.exception;

public class CategoriesNotFoundException extends RuntimeException {
    public CategoriesNotFoundException() {
        super("Aucune categorie n'a été trouvé");
    }
}
