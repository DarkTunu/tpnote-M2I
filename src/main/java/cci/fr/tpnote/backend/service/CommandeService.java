package cci.fr.tpnote.backend.service;

import cci.fr.tpnote.data.commande.Statut;
import cci.fr.tpnote.data.commande.Commande;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    public void mettreAJourStatut(Commande commande, Statut nouveauStatut) {

        if (commande.getStatut() != Statut.EN_COURS) {
            throw new IllegalStateException(
                    "Impossible de modifier une commande PAYEE ou ANNULEE"
            );
        }

        if (nouveauStatut == Statut.PAYE || nouveauStatut == Statut.ANNULE) {
            commande.setStatut(nouveauStatut);
        } else {
            throw new IllegalArgumentException("Transition non autorisée");
        }
    }
}
