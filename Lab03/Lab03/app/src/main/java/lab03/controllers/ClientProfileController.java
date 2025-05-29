package lab03.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import lab03.Ingresso;
import lab03.models.Model;

public class ClientProfileController {
    @FXML
    private ListView<Ingresso> ticketsListView;
    @FXML
    private TextArea ticketDetailsArea;

    @FXML
    public void initialize() {
        Model model = Model.getInstance();

        // customize the list view to show a formatted ticket name
        ticketsListView.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Ingresso ticket, boolean empty) {
                super.updateItem(ticket, empty);
                if (ticket == null || empty) {
                    setText("");
                } else {
                    String editedName = "🎟️ " + ticket.getEvento().getNome().toUpperCase();
                    setText(editedName);
                }
            }
        });

        // Populate the list view
        ticketsListView.getItems().addAll(model.getMeusIngressos());
        ticketsListView.setOnMouseClicked(this::handleTicketSelection);
    }

    private void handleTicketSelection(MouseEvent event) {
        Ingresso selected = ticketsListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String content = selected.getEvento().getDescricao();
            ticketDetailsArea.setText(content);
        }
    }
}