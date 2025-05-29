package lab03.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lab03.OfertaIngresso;
import lab03.models.MarketplaceModel;
import lab03.models.Model;

public class MarketplaceController {
    private static MarketplaceController instance;
    private final ObservableList<OfertaIngresso> offers = FXCollections.observableArrayList();

    @FXML
    private TableView<OfertaIngresso> offerTable;

    @FXML
    private TableColumn<OfertaIngresso, String> eventNameColumn;

    @FXML
    private TableColumn<OfertaIngresso, String> ownerColumn;

    @FXML
    private TableColumn<OfertaIngresso, Double> priceColumn;

    @FXML
    private javafx.scene.control.Label saldo;

    public static MarketplaceController getInstance() {
        if (instance == null) {
            instance = new MarketplaceController();
        }
        return instance;
    }

    @FXML
    public void initialize() {
        updateSaldo();

        // Define o valor que será exibido em cada coluna
        eventNameColumn.setCellValueFactory(cellData ->
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEvento().getNome())
        );

        ownerColumn.setCellValueFactory(cellData ->
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAnunciante())
        );

        priceColumn.setCellValueFactory(cellData ->
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPreco())
        );

        // Carrega dados fictícios ou do modelo
        updateOffers();

        // Vincula os dados à tabela
        offerTable.setItems(offers);

        // // Configurando o duplo clique para abrir compra
        // offerTable.setRowFactory(tv -> {
        //     TableRow<OfertaIngresso> row = new TableRow<>();
        //     row.setOnMouseClicked(event -> {
        //         if (event.getClickCount() == 2 && (!row.isEmpty())) {
        //             OfertaIngresso clickedOffer = row.getItem();
        //             openPurchaseTab(clickedOffer);
        //         }
        //     });
        //     return row;
        // });
    }

    public void updateOffers() {
        // Aqui você pode carregar dados reais do modelo (exemplo fictício)
        this.offers.clear();
        MarketplaceModel marketplaceModel = MarketplaceModel.getInstance();
        this.offers.addAll(marketplaceModel.getOfertas());
    }

    @FXML
    private void handleCreateOffer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab03/interface/CreateOffer.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Criar oferta");
            stage.setScene(new Scene(root, 500, 300));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateSaldo() {
        double updatedSaldo = Model.getInstance().getSaldo();
        this.saldo.setText(String.format("Saldo: R$ %.2f", updatedSaldo));
    }

    @FXML
    private void handlePurchase(){
        OfertaIngresso selectedOffer = offerTable.getSelectionModel().getSelectedItem();
        if (selectedOffer == null) {
            return; // Nenhuma oferta selecionada
        }
        
        try {
            MarketplaceModel.getInstance().comprarIngresso(selectedOffer);
            updateSaldo();
            updateOffers(); 
        } catch (Exception e) {
            mostrarErro("Erro ao comprar ingresso: " + e.getMessage());
        }
    }

    @FXML
    private void handleSimulateSale() {
        // TODO
    }

    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}