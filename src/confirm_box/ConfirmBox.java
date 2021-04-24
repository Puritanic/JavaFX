package confirm_box;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);

        Button buttonY = new Button("Yes");
        Button buttonN = new Button("No");

        buttonY.setOnAction(e -> {
            answer = true;
            window.close();
        });
        buttonN.setOnAction(e -> {
            answer = false;
            window.close();
        });

        Label label = new Label(message);
        VBox layout = new VBox(10);
        HBox btnLayout = new HBox(25);
        btnLayout.getChildren().addAll(buttonY, buttonN);
        layout.getChildren().addAll(label, btnLayout);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
