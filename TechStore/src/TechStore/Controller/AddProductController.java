package TechStore.Controller;

import static TechStore.Controller.MainPageController.writeProductsToFile;
import TechStore.Model.Product;
import static TechStore.Model.Product.addProduct;
import static TechStore.Model.Product.isProductValid;
import static TechStore.Model.Product.productExists;
import TechStore.Model.User;
import TechStore.Views.AddProductView;
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

public class AddProductController extends AddProductView implements Initializable{
    
    String exceptionMessage;
    private final User user;

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
                alert.setHeaderText("Error adding Product");
                alert.setContentText(exceptionMessage);
                alert.showAndWait();
                exceptionMessage = "";
            }
            else if (productExists(name)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Product Exists");
                alert.setContentText(exceptionMessage);
                alert.showAndWait();
            }
            else {
                Product tempP = new Product();
                tempP.setName(name);
                tempP.setCategory(cat);
                tempP.setPrice(Double.parseDouble(price));
                tempP.setQuantity(Integer.parseInt(quantity));
                tempP.setUsername(user.getUsername());
                tempP.setDate(new Date());

                addProduct(tempP);
                writeProductsToFile();
                
                MainPageController addParentSaveParent = new MainPageController(user);
                Scene addProductSaveScene = new Scene(addParentSaveParent);
                Stage addProductSaveStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                addProductSaveStage.setScene(addProductSaveScene);
                addProductSaveStage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding product");
            alert.setContentText("Check your added values!");
            alert.showAndWait();
        }
    }

    @Override
    protected void handleProductCancel(ActionEvent actionEvent) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
