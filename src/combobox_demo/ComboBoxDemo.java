package combobox_demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    Stage window;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ComboBox Demo");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Matrix", "12 Monkeys", "Terminator", "Inception");
        comboBox.setPromptText("Choose your favorite movie");
        comboBox.setOnAction(e -> System.out.println("User selected: " + printMovie()));
        comboBox.setEditable(true);

        Button button = new Button("Click me");
        button.setOnAction(e -> printMovie());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private String printMovie() {
        System.out.println(comboBox.getValue());
        return comboBox.getValue();
    }
}
