package cci.fr.tpnote.backend.controller;

import cci.fr.tpnote.backend.repository.CommandeRepository;
import cci.fr.tpnote.backend.service.CommandeService;
import cci.fr.tpnote.data.commande.Commande;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeRepository repository;
    private final CommandeService service;

    public CommandeController(CommandeRepository repository,
                              CommandeService service) {
        this.repository = repository;
        this.service = service;
    }

    // POST /commandes — créer une commande vide
    @PostMapping
    public Commande creerCommande() {
        return repository.save(new Commande(null));
    }

    // GET /commandes — liste des commandes
    @GetMapping
    public List<Commande> getCommandes() {
        return repository.findAll();
    }

    // GET /commandes/{id} — détail d’une commande
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommande(@PathVariable Long id) {
        Commande commande = repository.findById(id);
        if (commande == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commande);
    }

    // PUT /commandes/{id}/statut — changement de statut (JSON)
    @PutMapping("/{id}/statut")
    public ResponseEntity<Commande> changerStatut(
            @PathVariable Long id,
            @RequestBody StatutRequest request) {

        Commande commande = repository.findById(id);
        if (commande == null) {
            return ResponseEntity.notFound().build();
        }

        service.mettreAJourStatut(commande, request.getStatut());
        return ResponseEntity.ok(commande);
    }
}
