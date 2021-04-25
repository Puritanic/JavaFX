package FXML_demo;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button submitButton;
    public Label firstLabel;
    public Label difficultyLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }

    public void handleButtonClick(ActionEvent actionEvent) {
        System.out.println("Button clicked");
    }
}
