package cci.fr.tpnote.client;

import cci.fr.tpnote.client.dto.ProduitDTO;
import cci.fr.tpnote.data.commande.Commande;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class ApiClientService {

    private final RestClient client =
            RestClient.create("http://localhost:8080");

    public List<ProduitDTO> getProduits() {
        return client.get()
                .uri("/produits")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }


    public List<Commande> getCommandes() {
        return client.get()
                .uri("/commandes")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
