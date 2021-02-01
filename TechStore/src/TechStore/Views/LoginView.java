package TechStore.Views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class LoginView extends AnchorPane {

    protected final TextField txtUsername;
    protected final Label lblPassword;
    protected final Label lblUsername;
    protected final PasswordField txtPassword;
    protected final Button btnLogin;
    protected final Label lblErrorMessage;

    public LoginView() {

        txtUsername = new TextField();
        lblPassword = new Label();
        lblUsername = new Label();
        txtPassword = new PasswordField();
        btnLogin = new Button();
        lblErrorMessage = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: white;");

        txtUsername.setLayoutX(283.0);
        txtUsername.setLayoutY(143.0);

        lblPassword.setLayoutX(169.0);
        lblPassword.setLayoutY(190.0);
        lblPassword.setPrefHeight(25.0);
        lblPassword.setPrefWidth(104.0);
        lblPassword.setText("Password:");

        lblUsername.setLayoutX(170.0);
        lblUsername.setLayoutY(143.0);
        lblUsername.setPrefHeight(25.0);
        lblUsername.setPrefWidth(104.0);
        lblUsername.setText("Username:");

        txtPassword.setLayoutX(283.0);
        txtPassword.setLayoutY(190.0);

        btnLogin.setLayoutX(369.0);
        btnLogin.setLayoutY(232.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(25.0);
        btnLogin.setPrefWidth(63.0);
        btnLogin.setText("Login");
        btnLogin.setOnAction(this::handleLogin);

        lblErrorMessage.setAlignment(javafx.geometry.Pos.CENTER);
        lblErrorMessage.setLayoutX(12.0);
        lblErrorMessage.setLayoutY(298.0);
        lblErrorMessage.setPrefHeight(48.0);
        lblErrorMessage.setPrefWidth(574.0);
        lblErrorMessage.setTextFill(javafx.scene.paint.Color.RED);

        getChildren().add(txtUsername);
        getChildren().add(lblPassword);
        getChildren().add(lblUsername);
        getChildren().add(txtPassword);
        getChildren().add(btnLogin);
        getChildren().add(lblErrorMessage);
    }
    
    protected abstract Boolean handleLogin(javafx.event.ActionEvent actionEvent);

}
