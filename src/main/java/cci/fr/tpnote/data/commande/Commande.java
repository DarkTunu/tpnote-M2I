package cci.fr.tpnote.data.commande;

import cci.fr.tpnote.data.produits.Produit;

import java.util.ArrayList;
import java.util.List;

public class Commande {

    private Long id;
    private List<LigneCommande> lignes = new ArrayList<>();
    private Statut statut = Statut.EN_COURS;

    public Commande() {}

    public Commande(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public double getTotal() {
        return lignes.stream()
                .mapToDouble(ligne ->
                        ligne.getProduit().getPrix() * ligne.getQuantite()
                )
                .sum();
    }

    public void ajouterLigne(Produit produit, int quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être positive");
        }
        lignes.add(new LigneCommande(produit, quantite));
    }
}
