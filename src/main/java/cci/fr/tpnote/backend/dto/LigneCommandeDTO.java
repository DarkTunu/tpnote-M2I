package cci.fr.tpnote.backend.dto;

public class LigneCommandeDTO {

    private String produit;
    private int quantite;
    private double prixUnitaire;

    public LigneCommandeDTO(String produit, int quantite, double prixUnitaire) {
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public String getProduit() { return produit; }
    public int getQuantite() { return quantite; }
    public double getPrixUnitaire() { return prixUnitaire; }
}
