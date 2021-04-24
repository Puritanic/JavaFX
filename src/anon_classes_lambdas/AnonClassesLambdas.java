package anon_classes_lambdas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AnonClassesLambdas extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Anonymous Inner Classes and Lambda Expressions");

        VBox vbox = new VBox();
        Button button = new Button("Click me");
        Button amazingButton = new Button("I'm Amazing");

        vbox.getChildren().addAll(button, amazingButton);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Handling click with anonymous inner class");
            }
        });

        amazingButton.setOnAction(e -> {
            System.out.println("Evaluated Lambda Expression. Amazing.");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(vbox);

        Scene scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
