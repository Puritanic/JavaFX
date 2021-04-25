package using_properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UsingPropertiesDemo extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Using properties demo");

        Person person = new Person();
        person.firstNameProperty().addListener((v, oldVal, newVal) -> {
            System.out.println("Old value: "+ oldVal);
            System.out.println("New value: "+ newVal);
        });
        person.setFirstName("Darko");

        Button button = new Button("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
