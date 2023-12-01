package edu.lawrence.tilegame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {
    @FXML
    private VBox vBox;
    private GamePane game;
    //private Label label;
    
//    @FXML
//    private void undo() {
//        game.undoPlay();
//    }
//    
//    @FXML
//    private void done() {
//        game.endPlay();
//    }
//    
//    @FXML
//    private void discard() {
//        game.discard();
//    }
    
    @FXML
    private void exit() {
        Platform.exit();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new GamePane();
        game.setPrefSize(1000,860);
        vBox.getChildren().add(game);
    }  
}
