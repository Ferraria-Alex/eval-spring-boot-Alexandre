package com.alex.evalspring.exception;

import com.alex.evalspring.model.Categorie;

public class CategorieMissingParametersException extends RuntimeException {
    public CategorieMissingParametersException(Categorie categorie) {
        super("La nouvelle categorie n'est pas valide : Paramètres mal saisis. \n Libelle : " + categorie.getLibelle());
    }
}