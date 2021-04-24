package input_validation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputValidationDemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Input Validation Demo");

        TextField nameInput = new TextField("Darko");
        Button button = new Button("Click me");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(nameInput, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input, String message){
        try {
            int age = Integer.parseInt(message);
            System.out.println("User is " + age + " old.");
            return true;
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
