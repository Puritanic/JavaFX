package menu_demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menudemo extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu Demo");

        // File menu
        Menu fileMenu = new Menu("_File");
        // Menu items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new MenuItem("Import..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        // Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().addAll(new MenuItem("Cut"));
        editMenu.getItems().addAll(new MenuItem("Copy"));
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Tried to paste something..."));
        paste.setDisable(true);
        editMenu.getItems().addAll(paste);

        // Help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line numbers");
        showLines.setOnAction(e -> {
            if(showLines.isSelected()){
                System.out.println("Lines will be shown...");
            } else {
                System.out.println("Lines will be hidden...");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Autosave changes");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        // Difficulty menu
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        // Main Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
