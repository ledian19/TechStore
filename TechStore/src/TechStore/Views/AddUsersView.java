package TechStore.Views;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class AddUsersView extends AnchorPane {

    protected final Label lblAddUser;
    protected final TextField txtUsername;
    protected final PasswordField txtPassword;
    protected final TextField txtFullname;
    protected final TextField txtUserlevel;
    protected final TextField txtSalary;
    protected final TextField txtPhone;
    protected final TextField txtEmail;
    protected final DatePicker txtDatepicker;
    protected final Label lblPassword;
    protected final Label lblFullname;
    protected final Label lblBirthday;
    protected final ButtonBar buttonBar;
    protected final Label lblUsername;
    protected final Button btnSave;
    protected final Button btnCancel;
    protected final Label lblUserlevel;
    protected final Label lblSalary;
    protected final Label lblPhone;
    protected final Label lblEmail;

    public AddUsersView() {

        lblAddUser = new Label();
        txtUsername = new TextField();
        txtPassword = new PasswordField();
        txtFullname = new TextField();
        txtDatepicker = new DatePicker();
        txtUserlevel = new TextField();
        txtSalary = new TextField();
        txtPhone = new TextField();
        txtEmail = new TextField();
        lblPassword = new Label();
        lblFullname = new Label();
        lblBirthday = new Label();
        buttonBar = new ButtonBar();
        lblUsername = new Label();
        btnSave = new Button();
        btnCancel = new Button();
        lblUserlevel = new Label();
        lblSalary = new Label();
        lblPhone = new Label();
        lblEmail = new Label();

        setId("AnchorPane");
        setPrefHeight(444.0);
        setPrefWidth(504.0);

        lblAddUser.setLayoutX(14.0);
        lblAddUser.setLayoutY(14.0);
        lblAddUser.setText("Add User");

        txtUsername.setLayoutX(219.0);
        txtUsername.setLayoutY(59.0);
        
        txtPassword.setLayoutX(219.0);
        txtPassword.setLayoutY(97.0);

        txtFullname.setLayoutX(219.0);
        txtFullname.setLayoutY(130.0);

        lblPassword.setLayoutX(126.0);
        lblPassword.setLayoutY(101.0);
        lblPassword.setText("Password");

        lblFullname.setLayoutX(125.0);
        lblFullname.setLayoutY(134.0);
        lblFullname.setText("Full name");

        lblBirthday.setLayoutX(125.0);
        lblBirthday.setLayoutY(170.0);
        lblBirthday.setText("Birthday");

        buttonBar.setLayoutX(159.0);
        buttonBar.setLayoutY(372.0);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);


        lblUsername.setLayoutX(126.0);
        lblUsername.setLayoutY(64.0);
        lblUsername.setText("Username");

        txtDatepicker.setLayoutX(219.0);
        txtDatepicker.setLayoutY(165.0);
        txtDatepicker.setPrefHeight(27.0);
        txtDatepicker.setPrefWidth(161.0);

        btnSave.setDefaultButton(true);
        btnSave.setLayoutX(193.0);
        btnSave.setLayoutY(378.0);
        btnSave.setMnemonicParsing(false);
        btnSave.setOnAction(this::handleUserSave);
        btnSave.setText("Save");

        btnCancel.setLayoutX(273.0);
        btnCancel.setLayoutY(378.0);
        btnCancel.setMnemonicParsing(false);
        btnCancel.setOnAction(this::handleUserCancel);
        btnCancel.setText("Cancel");

        lblUserlevel.setLayoutX(124.0);
        lblUserlevel.setLayoutY(208.0);
        lblUserlevel.setText("Userlevel");

        lblSalary.setLayoutX(124.0);
        lblSalary.setLayoutY(241.0);
        lblSalary.setText("Salary");

        lblPhone.setLayoutX(124.0);
        lblPhone.setLayoutY(279.0);
        lblPhone.setText("Phone");

        lblEmail.setLayoutX(124.0);
        lblEmail.setLayoutY(313.0);
        lblEmail.setText("Email");

        txtUserlevel.setLayoutX(219.0);
        txtUserlevel.setLayoutY(203.0);

        txtSalary.setLayoutX(219.0);
        txtSalary.setLayoutY(236.0);

        txtPhone.setLayoutX(219.0);
        txtPhone.setLayoutY(274.0);

        txtEmail.setLayoutX(219.0);
        txtEmail.setLayoutY(308.0);

        getChildren().add(lblAddUser);
        getChildren().add(lblUsername);
        getChildren().add(txtUsername);
        getChildren().add(txtPassword);
        getChildren().add(txtFullname);
        getChildren().add(txtDatepicker);
        getChildren().add(txtUserlevel);
        getChildren().add(txtSalary);
        getChildren().add(txtPhone);
        getChildren().add(txtEmail);
        getChildren().add(lblPassword);
        getChildren().add(lblFullname);
        getChildren().add(lblBirthday);
        getChildren().add(buttonBar);
        getChildren().add(btnSave);
        getChildren().add(btnCancel);
        getChildren().add(lblUserlevel);
        getChildren().add(lblSalary);
        getChildren().add(lblPhone);
        getChildren().add(lblEmail);

    }

    protected abstract void handleUserSave(javafx.event.ActionEvent actionEvent);

    protected abstract void handleUserCancel(javafx.event.ActionEvent actionEvent);

}
