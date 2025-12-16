package cci.fr.tpnote.data.commande;

import cci.fr.tpnote.data.produits.Produit;

public class LigneCommande {

    private Produit produit;
    private int quantite;

    public LigneCommande() {}

    public LigneCommande(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }
}
