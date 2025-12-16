package cci.fr.tpnote.backend.repository;

import cci.fr.tpnote.data.produits.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProduitsEnMemoire implements ProduitRepository {

    private final List<Produit> produits = List.of(
            new Boisson(1L, "Café", 1.50),
            new Boisson(2L, "Thé", 1.80),
            new Viennoiseries(3L, "Croissant", 1.20),
            new Viennoiseries(4L, "Pain au chocolat", 1.30)
    );

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Optional<Produit> findById(Long id) {
        return produits.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
