package handling_events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Whenever we want to handle user events we have to implement EventHandler interface
public class HandlingEvents extends Application implements EventHandler<ActionEvent> {
    Button button;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Handling user events");

        button = new Button("Click me");
        // We're saying here with _this_, is that whenever the button is clicked
        // the code to handle that is in this class (handle method).
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This is going to be called whenever the user clicks the button
     * @param event Action event
     */
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button){
            System.out.println("The only button we have is clicked");
        }
    }
}
