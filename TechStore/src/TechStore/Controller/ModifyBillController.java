package TechStore.Controller;

import static TechStore.Model.Bill.isBillValid;
import static TechStore.Controller.MainPageController.modifyBillIndex;
import static TechStore.Controller.MainPageController.writeTransactionsToFile;
import TechStore.Model.Bill;
import static TechStore.Model.Bill.updateBill;
import TechStore.Model.User;
import TechStore.Views.AddTransactionView;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ModifyBillController extends AddTransactionView implements Initializable {

    String exceptionMessage;
    private final User user;

    public ModifyBillController(User user, String n, Double p, int q) {
        this.user = user;
        
        txtProductName.setText(n);
        txtPrice.setText(p.toString());
        txtQuantity.setText(Integer.toString(q));
    }

    @Override
    protected void handleTransactionCancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText("Are you sure you wish to cancel?");
        alert.setContentText("Information not saved will be lost!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MainPageController modifyBillParent = new MainPageController(user);

            Scene modifyBillScene = new Scene(modifyBillParent);
            Stage modifyBillStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyBillStage.setScene(modifyBillScene);
            modifyBillStage.show();
        }
    }

    @Override
    protected void handleTransactionSave(ActionEvent event) {
        String billName = txtProductName.getText();
        String billPrice = txtPrice.getText();
        String billQuantity = txtQuantity.getText();

        try {
            exceptionMessage = isBillValid(billName, Double.parseDouble(billPrice), Integer.parseInt(billQuantity));
            if (exceptionMessage.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding bill");
                alert.setContentText(exceptionMessage);
                alert.showAndWait();
                exceptionMessage = "";
            } else {
                Bill tempBill = new Bill();
                tempBill.setName(billName);
                tempBill.setPrice(Double.parseDouble(billPrice));
                tempBill.setQuantity(Integer.parseInt(billQuantity));
                tempBill.setTotal(Double.parseDouble(billPrice) * Integer.parseInt(billQuantity));
                tempBill.setUsername(user.getUsername());
                tempBill.setDate(new Date());
                updateBill(modifyBillIndex, tempBill);
                writeTransactionsToFile();
            }
            MainPageController modifyBillParent = new MainPageController(user);

            Scene modifyBillScene = new Scene(modifyBillParent);
            Stage modifyBillStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyBillStage.setScene(modifyBillScene);
            modifyBillStage.show();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding bill");
            alert.setContentText("Form contains empty fields!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
