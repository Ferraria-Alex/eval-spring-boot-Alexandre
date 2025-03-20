package com.alex.evalspring.service;

import com.alex.evalspring.exception.ProduitAlreadyExistsException;
import com.alex.evalspring.exception.ProduitMissingParametersException;
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

    public List<Produit> getAllProduits() {

        if (produitRepository.count() == 0) {
            throw new ProduitsNotFoundException();
        }

        List<Produit> produits = new ArrayList<>();
        for (Produit p : produitRepository.findAll()) {
            produits.add(p);
        }

        return produits;
    }

    public Produit getProduitById(Long id) {

        if(produitRepository.findById(id).isEmpty()){
            throw new ProduitNotFoundException(id);
        };

        return produitRepository.findById(id).get();
    }

    public Produit saveProduit(Produit newProduit) {

        if(newProduit.getNom() == null || newProduit.getNom().isEmpty() || newProduit.getPrix() == null || newProduit.getPrix().isNaN()) {
            throw new ProduitMissingParametersException(newProduit);
        }

        List<Produit> produits = getAllProduits();
        for (Produit produit : produits) {
           if(produit.getNom().equals(newProduit.getNom())){
                throw new ProduitAlreadyExistsException(newProduit.getNom());
           }
        }

        return produitRepository.save(newProduit);
    }
}
