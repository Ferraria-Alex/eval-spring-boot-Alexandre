package com.alex.evalspring.controller;

import com.alex.evalspring.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProduitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleProduitNotFound(ProduitNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }

    @ExceptionHandler(ProduitsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleProduitsNotFound(ProduitsNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }

    @ExceptionHandler(ProduitAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> handleProduitAlreadyExists(ProduitAlreadyExistsException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errors);
    }

    @ExceptionHandler(ProduitMissingParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleProduitMissingParameters(ProduitMissingParametersException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(CategorieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleCategorieNotFound(CategorieNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }

    @ExceptionHandler(CategoriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleCategoriesNotFound(CategoriesNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }

    @ExceptionHandler(CategorieAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> handleCategorieAlreadyExists(CategorieAlreadyExistsException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errors);
    }

    @ExceptionHandler(CategorieMissingParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleCategorieMissingParameters(CategorieMissingParametersException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

}
