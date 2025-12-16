package cci.fr.tpnote.backend.dto;

public class ProduitDTO {

    private Long id;
    private String nom;
    private double prix;
    private String type;

    public ProduitDTO(Long id, String nom, double prix, String type) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public String getType() { return type; }
}
