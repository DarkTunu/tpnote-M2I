package cci.fr.tpnote.data.produits;

public class Viennoiseries extends Produit {

    public Viennoiseries() {
        super();
    }

    public Viennoiseries(Long id, String nom, double prix) {
        super(id, nom, prix);
    }

    @Override
    public String getType() {
        return "Viennoiserie";
    }
}
