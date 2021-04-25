package javafx_css_styling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StylingJavaFX extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("JavaFX Styling Demo");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name label
        Label nameLabel = new Label("Username");
        nameLabel.setStyle("-fx-text-fill: #e8e8e8");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);
        // Name input
        TextField nameInput = new TextField("Darko");
        GridPane.setConstraints(nameInput, 1, 0);

        // Pass label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);
        // Pass input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        Button signUpButton = new Button("Sign up");
        signUpButton.getStyleClass().add("button--blue");
        GridPane.setConstraints(signUpButton, 1, 3);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);

        Scene scene = new Scene(grid, 300, 300);
        scene.getStylesheets().add("javafx_css_styling/styles.css");
        window.setScene(scene);
        window.show();
    }
}
