package cci.fr.tpnote.client;

import cci.fr.tpnote.client.dto.ProduitDTO;
import cci.fr.tpnote.data.commande.Commande;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

    private final ApiClientService api = new ApiClientService();

    public void start(Stage stage) {

        // Table ProduitDTOs
        TableView<ProduitDTO> tableProduitDTOs = new TableView<>();

        TableColumn<ProduitDTO, String> colNom =
                new TableColumn<>("ProduitDTO");
        colNom.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(
                        p.getValue().getNom()
                ));

        TableColumn<ProduitDTO, String> colPrix =
                new TableColumn<>("Prix");
        colPrix.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(
                        String.format("%.2f €", p.getValue().getPrix())
                ));

        tableProduitDTOs.getColumns().addAll(colNom, colPrix);
        tableProduitDTOs.setItems(
                FXCollections.observableArrayList(api.getProduits())
        );

        // Table Commandes
        TableView<Commande> tableCommandes = new TableView<>();

        TableColumn<Commande, String> colId =
                new TableColumn<>("ID");
        colId.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getId().toString()
                ));

        TableColumn<Commande, String> colTotal =
                new TableColumn<>("Total");
        colTotal.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        String.format("%.2f €", c.getValue().getTotal())
                ));

        TableColumn<Commande, String> colStatut =
                new TableColumn<>("Statut");
        colStatut.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getStatut().name()
                ));

        tableCommandes.getColumns().addAll(colId, colTotal, colStatut);
        tableCommandes.setItems(
                FXCollections.observableArrayList(api.getCommandes())
        );

        VBox root = new VBox(10,
                new Label("Produits"),
                tableProduitDTOs,
                new Label("Commandes"),
                tableCommandes
        );

        stage.setScene(new Scene(root, 600, 500));
        stage.setTitle("Le Petit Grain - Gestion");
        stage.show();
    }
}
