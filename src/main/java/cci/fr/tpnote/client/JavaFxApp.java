package cci.fr.tpnote.client;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

    @Override
    public void start(Stage stage) {
        new MainView().start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
