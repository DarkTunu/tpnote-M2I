package cci.fr.tpnote.backend.controller;

import cci.fr.tpnote.backend.dto.CommandeDTO;
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
    public CommandeDTO creerCommande() {
        Commande c = repository.save(new Commande(null));
        return new CommandeDTO(
                c.getId(),
                c.getStatut().name(),
                c.getTotal()
        );
    }

    // GET /commandes — liste des commandes (DTO)
    @GetMapping
    public List<CommandeDTO> getCommandes() {
        return repository.findAll().stream()
                .map(c -> new CommandeDTO(
                        c.getId(),
                        c.getStatut().name(),
                        c.getTotal()
                ))
                .toList();
    }

    // PUT /commandes/{id}/statut — changement de statut
    @PutMapping("/{id}/statut")
    public ResponseEntity<CommandeDTO> changerStatut(
            @PathVariable Long id,
            @RequestBody StatutRequest request) {

        Commande commande = repository.findById(id);
        if (commande == null) {
            return ResponseEntity.notFound().build();
        }

        service.mettreAJourStatut(commande, request.getStatut());

        return ResponseEntity.ok(
                new CommandeDTO(
                        commande.getId(),
                        commande.getStatut().name(),
                        commande.getTotal()
                )
        );
    }
}
