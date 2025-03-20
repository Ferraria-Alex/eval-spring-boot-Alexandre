package com.alex.evalspring.service;

import com.alex.evalspring.exception.ProduitAlreadyExistsException;
import com.alex.evalspring.exception.ProduitNotFoundException;
import com.alex.evalspring.exception.ProduitsNotFoundException;
import com.alex.evalspring.model.Produit;
import com.alex.evalspring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAll() {

        if (produitRepository.count() == 0) {
            throw new ProduitsNotFoundException();
        }

        List<Produit> produits = new ArrayList<>();
        for (Produit p : produitRepository.findAll()) {
            produits.add(p);
        }

        return produits;
    }

    public Produit getById(Long id) {

        if(produitRepository.findById(id).isEmpty()){
            throw new ProduitNotFoundException(id);
        };

        return produitRepository.findById(id).get();
    }

    public Produit save(Produit produit) {
        List<Produit> produits = getAll();
        for (Produit p : produits) {
           if(p.getNom().equals(produit.getNom())){
                throw new ProduitAlreadyExistsException(produit.getNom());
           }
        }
        return produitRepository.save(produit);
    }
}
