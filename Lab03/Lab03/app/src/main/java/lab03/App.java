/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Essa classe possui apenas a função de inicializar a interface gráfica.
 * 
 * @author Vinicius Ventura Andreossi - RA 195125
 */
public class App extends Application {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab03/interface/MainWindow.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Loja de ingressos");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
