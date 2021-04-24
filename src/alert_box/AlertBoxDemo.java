package alert_box;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AlertBoxDemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Alert Boxes Demo");

        Button button = new Button("Click me");
        button.setOnAction(e -> {
            AlertBox.display("AlertBox", "This is AlertBox window");
        });

        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.show();
    }
}
