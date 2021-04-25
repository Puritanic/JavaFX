package treeview_demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {
    Stage window;
    TreeView<String> treeView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TreeView Demo");

        TreeItem<String> root, branchA, branchB;

        // Root
        root = new TreeItem<>();
        root.setExpanded(true);
        // Branch A
        branchA = makeBranch("BranchA", root);
        makeBranch("BranchAA", branchA);
        makeBranch("BranchAB", branchA);
        makeBranch("BranchAC", branchA);
        branchB = makeBranch("BranchB", root);
        makeBranch("BranchBA", branchB);
        makeBranch("BranchBB", branchB);
        makeBranch("BranchBC", branchB);
        // Tree
        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldVal, newVal) -> {
            if(newVal != null){
                System.out.println(newVal);
            }
        });

        Button button = new Button("Click me");

        VBox layout = new VBox(11);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().add(treeView);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String branchName, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(branchName);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
