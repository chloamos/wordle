package edu.lawrence.tilegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 875);
        stage.setScene(scene);
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        stage.setTitle("Tile Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}