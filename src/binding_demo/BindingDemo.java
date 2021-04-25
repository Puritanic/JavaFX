package binding_demo;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingDemo extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Binding properties demo");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));

        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());

        x.setValue(9);

        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());

        // Input & Labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome ");
        Label secondLabel = new Label();

        HBox textBox = new HBox(firstLabel, secondLabel);
        textBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, userInput, textBox);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
