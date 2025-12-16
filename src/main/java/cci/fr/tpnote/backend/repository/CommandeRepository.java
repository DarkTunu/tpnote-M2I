package cci.fr.tpnote.backend.repository;

import cci.fr.tpnote.data.commande.Commande;
import java.util.List;

public interface CommandeRepository {

    Commande save(Commande commande);
    Commande findById(Long id);
    List<Commande> findAll();
}
