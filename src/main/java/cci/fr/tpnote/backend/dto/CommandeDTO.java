package cci.fr.tpnote.backend.dto;

public class CommandeDTO {

    private Long id;
    private String statut;
    private double total;

    public CommandeDTO(Long id, String statut, double total) {
        this.id = id;
        this.statut = statut;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getStatut() {
        return statut;
    }

    public double getTotal() {
        return total;
    }
}
