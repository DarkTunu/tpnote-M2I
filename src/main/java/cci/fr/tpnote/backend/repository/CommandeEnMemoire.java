package cci.fr.tpnote.backend.repository;

import cci.fr.tpnote.data.commande.Commande;
import cci.fr.tpnote.data.commande.Statut;
import cci.fr.tpnote.data.produits.Boisson;
import cci.fr.tpnote.data.produits.Viennoiseries;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Repository
public class CommandeEnMemoire implements CommandeRepository {

    private final Map<Long, Commande> commandes = new HashMap<>();
    private long sequence = 1L;

    // Commandes préchargé pour exemple
    @PostConstruct
    public void init() {

        Commande c1 = new Commande(sequence++);
        c1.ajouterLigne(new Boisson(1L, "Café", 1.50), 2);
        c1.ajouterLigne(new Viennoiseries(3L, "Croissant", 1.20), 1);

        Commande c2 = new Commande(sequence++);
        c2.ajouterLigne(new Boisson(2L, "Thé", 1.80), 1);
        c2.setStatut(Statut.PAYE);

        commandes.put(c1.getId(), c1);
        commandes.put(c2.getId(), c2);
    }

    @Override
    public Commande save(Commande commande) {
        if (commande.getId() == null) {
            commande = new Commande(sequence++);
        }
        commandes.put(commande.getId(), commande);
        return commande;
    }

    @Override
    public Commande findById(Long id) {
        return commandes.get(id);
    }

    @Override
    public List<Commande> findAll() {
        return new ArrayList<>(commandes.values());
    }
}
