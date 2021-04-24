package app_cleanup_on_close;

import confirm_box.ConfirmBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppCleanupDemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("App Cleanup Demo");

        window.setOnCloseRequest(e -> {
            // Prevent the OS from closing the window anyway (preventDefault() in Js)
            e.consume();
            closeProgram();
        });

        Button button = new Button("Close App");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        System.out.println("Pre-exit cleanup.");

        boolean answer = ConfirmBox.display("ConfirmBox", "Are you sure you want to exit?");

        if (answer) window.close();
    }
}
