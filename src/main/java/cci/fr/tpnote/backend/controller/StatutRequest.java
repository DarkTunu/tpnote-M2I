package cci.fr.tpnote.backend.controller;

import cci.fr.tpnote.data.commande.Statut;

public class StatutRequest {
    private Statut statut;
    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }
}
