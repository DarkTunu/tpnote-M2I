package cci.fr.tpnote.client;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

    @Override
    public void start(Stage stage) {
        // Rendu de la fenetre JavaFX
        new MainView().start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
