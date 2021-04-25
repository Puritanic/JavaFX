package listview_demo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    Stage window;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ListView Demo");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "Contact", "Titanic", "Avatar");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Click me");
        button.setOnAction(e -> buttonClicked());

        VBox layout = new VBox(11);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String str: movies){
            message += str + "\n";
        }
        System.out.println(message);
    }
}
