package checkbox_demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("CheckBox Demo");

        CheckBox chkBoxA = new CheckBox("Bacon");
        CheckBox chkBoxB = new CheckBox("Salad");
        CheckBox chkBoxC = new CheckBox("Bread");
        CheckBox chkBoxD = new CheckBox("Cheese");
        chkBoxC.setSelected(true);
        chkBoxD.setSelected(true);

        Button button = new Button("Order Now");
        button.setOnAction(e -> handleOptions(chkBoxA, chkBoxB));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(chkBoxA, chkBoxB, chkBoxC, chkBoxD, button);

        Scene scene = new Scene(layout, 200, 300);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox checkBoxA, CheckBox checkBoxB){
        String message = "User's order:\n";

        if (checkBoxA.isSelected()){
            message += "Bacon\n";
        }
        if (checkBoxB.isSelected()){
            message += "Salad\n";
        }
        System.out.println(message);
    }
}
