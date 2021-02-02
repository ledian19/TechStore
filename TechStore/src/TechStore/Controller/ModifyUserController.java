package TechStore.Controller;

import static TechStore.Controller.LoginViewController.writeUsersToFile;
import static TechStore.Controller.MainPageController.modifyUserIndex;
import TechStore.Model.User;
import static TechStore.Model.User.isUserValid;
import static TechStore.Model.User.updateUser;
import TechStore.Views.AddUsersView;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ModifyUserController extends AddUsersView {

    private final User user;

    public ModifyUserController(User user, User selectedUser){
        this.user = user;
        
        txtFullname.setText(selectedUser.getFullname());
        txtUsername.setText(selectedUser.getUsername());
        txtUserlevel.setText(selectedUser.getUserLevel().toString());
        txtSalary.setText(selectedUser.getSalary().toString());
        txtEmail.setText(selectedUser.getEmail());
        txtPhone.setText(selectedUser.getPhone());
    }

    @Override
    protected void handleUserSave(ActionEvent actionEvent) {
        User newUser = new User();
        
        String exceptionMessage="";
        
        try{
            newUser.setUsername(txtUsername.getText());
            newUser.setPassword(txtPassword.getText());
            newUser.setFullname(txtFullname.getText());
            newUser.setSalary(Double.parseDouble(txtSalary.getText()));
            newUser.setPhone(txtPhone.getText());
            newUser.setEmail(txtEmail.getText());
            newUser.setBirthday(java.sql.Date.valueOf(txtDatepicker.getValue()));
            newUser.setUserLevel(Integer.parseInt(txtUserlevel.getText()));
        } catch (Exception ex){
            exceptionMessage="Please insert correct values";
        }
        try {
            exceptionMessage = isUserValid(newUser, true);
            if (exceptionMessage.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding user");
                alert.setContentText(exceptionMessage);
                alert.showAndWait();
                exceptionMessage = "";
            }
            else {
                updateUser(modifyUserIndex, newUser);
                writeUsersToFile();
                
                MainPageController addParentSaveParent = new MainPageController(user);
                Scene addMainSaveScene = new Scene(addParentSaveParent);
                Stage addMainSaveStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                addMainSaveStage.setScene(addMainSaveScene);
                addMainSaveStage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding User");
            alert.setContentText("Check your added values!");
            alert.showAndWait();
        }
    }

    @Override
    protected void handleUserCancel(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText("Are you sure you wish to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MainPageController mainPageParent = new MainPageController(user);
            Scene mainPageScene = new Scene(mainPageParent);
            Stage mainPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            mainPageStage.setScene(mainPageScene);
            mainPageStage.show();
        }
    }
}
