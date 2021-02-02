package TechStore.Controller;

import static TechStore.Controller.MainPageController.modifyProductIndex;
import static TechStore.Controller.MainPageController.writeProductsToFile;
import TechStore.Model.Product;
import static TechStore.Model.Product.isProductValid;
import static TechStore.Model.Product.productExists;
import static TechStore.Model.Product.updateProduct;
import TechStore.Model.User;
import TechStore.Views.AddProductView;
import java.util.Date;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ModifyProductController extends AddProductView {
    
    private final User user;

    public ModifyProductController(User user, String catName, String name, Double p, int q){
        this.user = user;
        
        txtProductName.setText(name);
        txtPrice.setText(p.toString());
        txtQuantity.setText(Integer.toString(q));
        txtCategory.setText(catName);
    }

    @Override
    protected void handleProductSave(ActionEvent actionEvent) {
        String name = txtProductName.getText();
        String cat = txtCategory.getText();
        String price = txtPrice.getText();
        String quantity = txtQuantity.getText();

        try {
            String exceptionMessage = isProductValid(name, Double.parseDouble(price), Integer.parseInt(quantity), cat);
            if (exceptionMessage.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding product");
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
            } else {
                Product tempP = new Product();
                tempP.setName(name);
                tempP.setCategory(cat);
                tempP.setPrice(Double.parseDouble(price));
                tempP.setQuantity(Integer.parseInt(quantity));
                tempP.setUsername(user.getUsername());
                tempP.setDate(new Date());
                
                updateProduct(modifyProductIndex, tempP);
                writeProductsToFile();
            }
            MainPageController modifyProductParent = new MainPageController(user);

            Scene modifyProductScene = new Scene(modifyProductParent);
            Stage modifyProductStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            modifyProductStage.setScene(modifyProductScene);
            modifyProductStage.show();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error adding product");
            alert.setContentText("Form contains empty fields!");
            alert.showAndWait();
        }
    }

    @Override
    protected void handleProductCancel(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText("Are you sure you wish to cancel?");
        alert.setContentText("Information not saved will be lost!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MainPageController modifyParent = new MainPageController(user);

            Scene modifyMainScene = new Scene(modifyParent);
            Stage modifyMainStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            modifyMainStage.setScene(modifyMainScene);
            modifyMainStage.show();
        }
    }

}
