module edu.lawrence.tilegame {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.lawrence.tilegame to javafx.fxml;
    exports edu.lawrence.tilegame;
}
