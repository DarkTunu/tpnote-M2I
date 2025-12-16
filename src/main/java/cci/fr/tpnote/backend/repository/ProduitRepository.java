package cci.fr.tpnote.backend.repository;

import cci.fr.tpnote.data.produits.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository {

    List<Produit> findAll();

    Optional<Produit> findById(Long id);
}
