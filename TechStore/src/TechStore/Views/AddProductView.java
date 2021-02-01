package TechStore.Views;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class AddProductView extends AnchorPane {

    protected final Label lblAddPart;
    protected final TextField txtProductName;
    protected final TextField txtPrice;
    protected final Label lblProductName;
    protected final Label lblPrice;
    protected final TextField txtQuantity;
    protected final Label lblQuantity;
    protected final ButtonBar buttonBar;
    protected final Button btnSave;
    protected final Button btnCancel;
    protected final TextField txtCategory;
    protected final Label lblCategory;

    public AddProductView() {

        lblAddPart = new Label();
        txtProductName = new TextField();
        txtPrice = new TextField();
        lblProductName = new Label();
        lblPrice = new Label();
        txtQuantity = new TextField();
        lblQuantity = new Label();
        buttonBar = new ButtonBar();
        btnSave = new Button();
        btnCancel = new Button();
        txtCategory = new TextField();
        lblCategory = new Label();

        setId("AnchorPane");
        setPrefHeight(300.0);
        setPrefWidth(300.0);

        lblAddPart.setLayoutX(14.0);
        lblAddPart.setLayoutY(14.0);
        lblAddPart.setText("Add Product");

        txtProductName.setLayoutX(112.0);
        txtProductName.setLayoutY(84.0);

        txtPrice.setLayoutX(112.0);
        txtPrice.setLayoutY(117.0);

        lblProductName.setLayoutX(19.0);
        lblProductName.setLayoutY(88.0);
        lblProductName.setText("Product Name");

        lblPrice.setLayoutX(18.0);
        lblPrice.setLayoutY(121.0);
        lblPrice.setText("Price/Cost");

        txtQuantity.setLayoutX(112.0);
        txtQuantity.setLayoutY(153.0);

        lblQuantity.setLayoutX(18.0);
        lblQuantity.setLayoutY(157.0);
        lblQuantity.setText("Quantity");

        buttonBar.setLayoutX(87.0);
        buttonBar.setLayoutY(254.0);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);

        btnSave.setDefaultButton(true);
        btnSave.setMnemonicParsing(false);
        btnSave.setOnAction(this::handleProductSave);
        btnSave.setText("Save");

        btnCancel.setMnemonicParsing(false);
        btnCancel.setOnAction(this::handleProductCancel);
        btnCancel.setText("Cancel");

        txtCategory.setLayoutX(112.0);
        txtCategory.setLayoutY(51.0);

        lblCategory.setLayoutX(19.0);
        lblCategory.setLayoutY(55.0);
        lblCategory.setText("Category");

        getChildren().add(lblAddPart);
        getChildren().add(txtProductName);
        getChildren().add(txtPrice);
        getChildren().add(lblProductName);
        getChildren().add(lblPrice);
        getChildren().add(txtQuantity);
        getChildren().add(lblQuantity);
        buttonBar.getButtons().add(btnSave);
        buttonBar.getButtons().add(btnCancel);
        getChildren().add(buttonBar);
        getChildren().add(txtCategory);
        getChildren().add(lblCategory);

    }

    protected abstract void handleProductSave(javafx.event.ActionEvent actionEvent);

    protected abstract void handleProductCancel(javafx.event.ActionEvent actionEvent);

}
