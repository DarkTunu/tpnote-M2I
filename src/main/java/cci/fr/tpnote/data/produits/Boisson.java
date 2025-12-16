package cci.fr.tpnote.data.produits;

public class Boisson extends Produit {

    public Boisson() {
        super();
    }

    public Boisson(Long id, String nom, double prix) {
        super(id, nom, prix);
    }

    @Override
    public String getType() {
        return "Boisson";
    }
}
