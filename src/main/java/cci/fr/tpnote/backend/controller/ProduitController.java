package cci.fr.tpnote.backend.controller;

import cci.fr.tpnote.backend.dto.ProduitDTO;
import cci.fr.tpnote.backend.repository.ProduitRepository;
import cci.fr.tpnote.data.produits.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitRepository repository;

    public ProduitController(ProduitRepository repository) {
        this.repository = repository;
    }

    // GET /produits — liste des produits (DTO)
    @GetMapping
    public List<ProduitDTO> getProduits() {
        return repository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    // GET /produits/{id} — un produit (DTO)
    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        return repository.findById(id)
                .map(p -> ResponseEntity.ok(toDto(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    // mapping interne Entité → DTO
    private ProduitDTO toDto(Produit p) {
        return new ProduitDTO(
                p.getId(),
                p.getNom(),
                p.getPrix(),
                p.getClass().getSimpleName()
        );
    }
}
