package TechStore.Views;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class AddTransactionView extends AnchorPane {

    protected final Label lblAddPart;
    protected final TextField txtProductId;
    protected final TextField txtProductName;
    protected final TextField txtPrice;
    protected final Label lblID;
    protected final Label lblName;
    protected final Label lblPrice;
    protected final TextField txtQuantity;
    protected final Label lblQuantity;
    protected final ButtonBar buttonBar;
    protected final Button btnSave;
    protected final Button btnCancel;

    public AddTransactionView() {

        lblAddPart = new Label();
        txtProductId = new TextField();
        txtProductName = new TextField();
        txtPrice = new TextField();
        lblID = new Label();
        lblName = new Label();
        lblPrice = new Label();
        txtQuantity = new TextField();
        lblQuantity = new Label();
        buttonBar = new ButtonBar();
        btnSave = new Button();
        btnCancel = new Button();

        setId("AnchorPane");
        setPrefHeight(300.0);
        setPrefWidth(300.0);

        lblAddPart.setLayoutX(14.0);
        lblAddPart.setLayoutY(14.0);
        lblAddPart.setText("Add Part");

        txtProductId.setDisable(true);
        txtProductId.setLayoutX(112.0);
        txtProductId.setLayoutY(48.0);
        txtProductId.setText("Auto Gen - Disabled");

        txtProductName.setLayoutX(112.0);
        txtProductName.setLayoutY(84.0);

        txtPrice.setLayoutX(112.0);
        txtPrice.setLayoutY(117.0);

        lblID.setLayoutX(20.0);
        lblID.setLayoutY(52.0);
        lblID.setText("ID");

        lblName.setLayoutX(20.0);
        lblName.setLayoutY(88.0);
        lblName.setText("Product Name");

        lblPrice.setLayoutX(18.0);
        lblPrice.setLayoutY(121.0);
        lblPrice.setText("Price/Cost");

        txtQuantity.setLayoutX(112.0);
        txtQuantity.setLayoutY(155.0);

        lblQuantity.setLayoutX(18.0);
        lblQuantity.setLayoutY(159.0);
        lblQuantity.setText("Quantity");

        buttonBar.setLayoutX(87.0);
        buttonBar.setLayoutY(254.0);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);

        btnSave.setDefaultButton(true);
        btnSave.setMnemonicParsing(false);
        btnSave.setOnAction(this::handleTransactionSave);
        btnSave.setText("Save");

        btnCancel.setMnemonicParsing(false);
        btnCancel.setOnAction(this::handleTransactionCancel);
        btnCancel.setText("Cancel");

        getChildren().add(lblAddPart);
        getChildren().add(txtProductId);
        getChildren().add(txtProductName);
        getChildren().add(txtPrice);
        getChildren().add(lblID);
        getChildren().add(lblName);
        getChildren().add(lblPrice);
        getChildren().add(txtQuantity);
        getChildren().add(lblQuantity);
        buttonBar.getButtons().add(btnSave);
        buttonBar.getButtons().add(btnCancel);
        getChildren().add(buttonBar);

    }

    protected abstract void handleTransactionSave(javafx.event.ActionEvent actionEvent);

    protected abstract void handleTransactionCancel(javafx.event.ActionEvent actionEvent);

}
