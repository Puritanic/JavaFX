package confirm_box;

import alert_box.AlertBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ConfirmBoxDemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Confirm Boxe Demo");

        Button button = new Button("Click me");
        button.setOnAction(e -> {
           boolean answer = ConfirmBox.display("ConfirmBox", "Is this ConfirmBox window?");
            System.out.println("Answered: " + answer);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.show();
    }
}
