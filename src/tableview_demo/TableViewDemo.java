package tableview_demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
    Stage window;
    TableView<Product> tableView;
    TextField nameInput, priceInput, qtInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TableView Demo");


        // Name column
        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        // Price column
        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        // Quantity column
        TableColumn<Product, Integer> qtCol = new TableColumn<>("Quantity");
        qtCol.setMinWidth(100);
        qtCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(50);

        qtInput = new TextField();
        qtInput.setPromptText("Quantity");
        qtInput.setMinWidth(50);

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> onAddBtnClicked());
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> onDeleteBtnClicked());

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.getChildren().addAll(nameInput, priceInput, qtInput, addBtn, deleteBtn);

        tableView = new TableView<>();
        tableView.setItems(getProducts());
        tableView.getColumns().addAll(nameCol, priceCol, qtCol);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(tableView, hbox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    private void onDeleteBtnClicked() {
        ObservableList<Product> selectedProduct, allProducts;

        allProducts = tableView.getItems();
        selectedProduct = tableView.getSelectionModel().getSelectedItems();

        selectedProduct.forEach(allProducts::remove);
    }

    private void onAddBtnClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        try {
            product.setPrice(Double.parseDouble(priceInput.getText()));
            product.setQuantity(Integer.parseInt(qtInput.getText()));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        tableView.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        qtInput.clear();
    }

    /**
     * Gets all of the products
     *
     * @return list of products
     */
    public ObservableList<Product> getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Test1", 233.00, 12));
        products.add(new Product("Test32", 985.00, 2));
        products.add(new Product("Test442", 312.00, 7));
        products.add(new Product("Test22", 95.00, 56));
        products.add(new Product("Test01", 39.00, 250));
        products.add(new Product("Test89", 150.00, 40));

        return products;
    }
}
