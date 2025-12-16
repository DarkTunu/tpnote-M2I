package cci.fr.tpnote.backend.dto;

import cci.fr.tpnote.data.commande.Statut;
import java.util.List;

public class CommandeDetailDTO {

    private Long id;
    private Statut statut;
    private double total;
    private List<LigneCommandeDTO> lignes;

    public CommandeDetailDTO(Long id, Statut statut, double total, List<LigneCommandeDTO> lignes) {
        this.id = id;
        this.statut = statut;
        this.total = total;
        this.lignes = lignes;
    }

    public Long getId() { return id; }
    public Statut getStatut() { return statut; }
    public double getTotal() { return total; }
    public List<LigneCommandeDTO> getLignes() { return lignes; }
}
