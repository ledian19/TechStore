package TechStore.Controller;

import static TechStore.Controller.MainPageController.writeTransactionsToFile;
import TechStore.Model.Bill;
import static TechStore.Model.Bill.allBills;
import static TechStore.Model.Bill.isBillValid;
import static TechStore.Model.Product.productExists;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AddTransactionController extends AddTransactionView implements Initializable {

    String exceptionMessage;
    private final User user;

    public AddTransactionController(User user) {
        this.user = user;
    }

    @Override
    protected void handleTransactionCancel(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText("Are you sure you wish to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MainPageController mainPageParent = new MainPageController(user);
            Scene mainPageScene = new Scene(mainPageParent);
            Stage mainPageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainPageStage.setScene(mainPageScene);
            mainPageStage.show();
        }
    }

    @Override
    protected void handleTransactionSave(ActionEvent event) {
        String name = txtProductName.getText();
        String billPrice = txtPrice.getText();
        String billQuantity = txtQuantity.getText();

        try {
            exceptionMessage = isBillValid(name, Double.parseDouble(billPrice), Integer.parseInt(billQuantity));
            if (exceptionMessage.length() > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding bill");
                alert.setContentText(exceptionMessage);
                alert.showAndWait();
                exceptionMessage = "";
            }
            else if (!productExists(name)){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding bill. Product does not exist");
                alert.showAndWait();
            }
            else {
                Bill tempBill = new Bill();
                tempBill.setName(name);
                tempBill.setPrice(Double.parseDouble(billPrice));
                tempBill.setQuantity(Integer.parseInt(billQuantity));
                tempBill.setTotal(Double.parseDouble(billPrice) * Integer.parseInt(billQuantity));
                tempBill.setUsername(user.getUsername());
                tempBill.setDate(new Date());
                allBills.add(tempBill);
                writeTransactionsToFile();
                
                MainPageController addBillSaveParent = new MainPageController(user);
                Scene addBillSaveScene = new Scene(addBillSaveParent);
                Stage addBillSaveStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                addBillSaveStage.setScene(addBillSaveScene);
                addBillSaveStage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding bill");
            alert.setContentText("Check your added values!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
