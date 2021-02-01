package TechStore.Controller;

import static TechStore.Controller.MainPageController.writeProductsToFile;
import static TechStore.Controller.MainPageController.writeTransactionsToFile;
import TechStore.Model.Bill;
import static TechStore.Model.Bill.allBills;
import static TechStore.Model.Bill.isBillValid;
import TechStore.Model.Product;
import static TechStore.Model.Product.allProducts;
import static TechStore.Model.Product.isProductValid;
import TechStore.Model.User;
import TechStore.Views.AddProductView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AddProductController extends AddProductView implements Initializable{
    
    String exceptionMessage;
    private User user;

    public AddProductController(User user){
        this.user=user;
    }
    @Override
    protected void handleProductSave(ActionEvent actionEvent) {
        String name = txtProductName.getText();
        String cat = txtCategory.getText();
        String price = txtPrice.getText();
        String quantity = txtQuantity.getText();
        
        try {
            exceptionMessage = isProductValid(name, Double.parseDouble(price), Integer.parseInt(quantity), cat);
            if (exceptionMessage.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding bill");
                alert.setContentText(exceptionMessage);
                alert.showAndWait();
                exceptionMessage = "";
            } else {
                Product tempP = new Product();
                tempP.setName(name);
                tempP.setCategory(cat);
                tempP.setPrice(Double.parseDouble(price));
                tempP.setInStock(Integer.parseInt(quantity));
                tempP.setUsername(user.getUsername());
                tempP.setDate(new Date());
                allProducts.add(tempP);
                writeProductsToFile();
                
                MainPageController addBillSaveParent = new MainPageController(user);
                Scene addBillSaveScene = new Scene(addBillSaveParent);
                Stage addBillSaveStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                addBillSaveStage.setScene(addBillSaveScene);
                addBillSaveStage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding bill");
            alert.setContentText("Check your added values!");
            alert.showAndWait();
        }
    }

    @Override
    protected void handleProductCancel(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
