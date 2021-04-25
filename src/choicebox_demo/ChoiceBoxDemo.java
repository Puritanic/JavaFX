package choicebox_demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxDemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ChoiceBox Demo");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        // getItems returns the ObservableList object to which we can add items
        choiceBox.getItems().addAll("Apples", "Pineapple", "Pear", "Banana", "Tomato");
        // if we are dynamicaly populating ChoiceBox, we shouldn't use setValue to preselect some value. We should use code bellow:
        choiceBox.getSelectionModel().select(0);

        // Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        Button button = new Button("Click me");
        button.setOnAction(e -> getChoice(choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 200, 300);
        window.setScene(scene);
        window.show();
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String food = choiceBox.getValue();
        System.out.println(food);
    }
}
