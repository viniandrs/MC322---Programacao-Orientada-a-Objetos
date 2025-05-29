package lab03.controllers;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import lab03.Ingresso;
import lab03.models.MarketplaceModel;
import lab03.models.Model;

public class CreateOfferController {
    private Tab thisTab;

    @FXML
    private ListView<Ingresso> ticketListView;

    @FXML
    private TextField priceField;

    @FXML
    private TextField sellerNameField;

    private final Model model = Model.getInstance();

    @FXML
    public void initialize() {
        // Carrega os ingressos do cliente atual
        List<Ingresso> ingressos = model.getMeusIngressos();
        ticketListView.getItems().setAll(ingressos);

        // customize the list view to show formatted text
        ticketListView.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Ingresso ingresso, boolean empty) {
                super.updateItem(ingresso, empty);
                if (ingresso == null || empty) {
                    setText("");
                } else {
                    String editedName = "🎟️ " + ingresso.getEvento().getNome().toUpperCase() + " — " + ingresso.getEvento().getData();
                    setText(editedName);
                }
            }
        });
    }

    @FXML
    private void handleCreateOffer() throws IllegalArgumentException {
        Ingresso ingressoSelecionado = ticketListView.getSelectionModel().getSelectedItem();
        String precoStr = priceField.getText().trim();
        String nomeVendedor = sellerNameField.getText().trim();

        if (ingressoSelecionado == null || precoStr.isEmpty() || nomeVendedor.isEmpty()) {
            mostrarErro("Por favor, selecione um ingresso e preencha todos os campos.");
            return;
        }

        try {
            double preco = Double.parseDouble(precoStr);
            MarketplaceModel.getInstance().criarOferta(ingressoSelecionado.getEvento(), preco, nomeVendedor);
            MarketplaceController.getInstance().updateOffers();

            mostrarMensagem("Oferta criada com sucesso!");
        } catch (NumberFormatException e) {
            mostrarErro("Erro. Verifique o preço informado, o nome do anunciante e se o evento foi selecionado.");
        }
    }

    // As funcoes abaixo foram criadas por IA
    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void mostrarMensagem(String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
