package lab03.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lab03.eventos.Evento;
import lab03.models.Model;

/*
Foi utilizada IA para gerar o código abaixo na parte que configura a seleção de eventos na ListView.
*/

public class MainController {
    private static MainController instance;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private ListView<Evento> eventListView;

    @FXML
    private TextArea eventDetailsArea;

    @FXML
    private Button comprarIngressoButton;

    @FXML
    private Label saldo;

    // Initial state
    public MainController() {}

    @FXML
    private void initialize() {
        Model model = Model.getInstance();
        model.loadData();
        updateSaldo();

        // customize the list view to show a formatted event name and date
        eventListView.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Evento evento, boolean empty) {
                super.updateItem(evento, empty);
                if (evento == null || empty) {
                    setText("");
                } else {
                    String editedName = "🎟️ " + evento.getNome().toUpperCase() + " — " + evento.getData();
                    setText(editedName);
                }
            }
        });

        // Populate the list view
        eventListView.getItems().addAll(model.getEventos());
        
        // Show details when an event is selected
        eventListView.setOnMouseClicked(this::handleEventSelection);
    }

    private void handleEventSelection(MouseEvent event) {
        Evento selected = eventListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String content = selected.getDescricao();
            eventDetailsArea.setText(content);
        }
    }

    @FXML
    private void loadClientProfile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab03/interface/ClientProfile.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Minha Conta");
            stage.setScene(new Scene(root, 400, 500));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadMarketplace() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab03/interface/Marketplace.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Marketplace");
            stage.setScene(new Scene(root, 800, 500));
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
    private void comprarIngresso() {
        Evento eventoSelecionado = eventListView.getSelectionModel().getSelectedItem();
        if (eventoSelecionado == null) {
            return;
        }
        
        Model model = Model.getInstance();
        boolean sucesso = model.comprarIngresso(eventoSelecionado);
        if (sucesso) {
            eventDetailsArea.setText("Ingresso comprado com sucesso!");
            updateSaldo();
        } else {
            eventDetailsArea.setText("Erro ao comprar ingresso. Verifique seu saldo.");
        }
    }

}