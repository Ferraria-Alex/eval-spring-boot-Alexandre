package com.alex.evalspring.controller;

import com.alex.evalspring.model.Categorie;
import com.alex.evalspring.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Categorie> getCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/categorie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categorie getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    @PostMapping("/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }
}
