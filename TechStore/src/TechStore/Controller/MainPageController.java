package TechStore.Controller;

import static TechStore.Controller.LoginViewController.readAllUsersFromFile;
import static TechStore.Controller.LoginViewController.writeUsersToFile;
import TechStore.Model.Bill;
import static TechStore.Model.Bill.allBills;
import static TechStore.Model.Bill.deleteBill;
import static TechStore.Model.Bill.getAllBills;
import static TechStore.Model.Bill.lookupTransaction;
import TechStore.Model.Product;
import static TechStore.Model.Product.allProducts;
import static TechStore.Model.Product.deleteProduct;
import static TechStore.Model.Product.lookupProduct;
import TechStore.Model.User;
import static TechStore.Model.User.allUsers;
import static TechStore.Model.User.deleteUser;
import static TechStore.Model.User.lookupUser;
import TechStore.Views.MainPageView;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainPageController extends MainPageView implements Initializable {
    
    public static int modifyBillIndex;
    public static int modifyProductIndex;
    public static int modifyUserIndex;
    
    private final User user;

    public MainPageController(User user) {
        super(user.getUserLevel());
        this.user = user;
        
        billTotalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        billProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        billPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        billQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        productCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        productsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        employeeUsernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        employeeRoleColumn.setCellValueFactory(new PropertyValueFactory<>("userLevel"));
        employeeSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employeePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        employeeEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeBirthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        
        readAllTransactionsFromFile();
        readAllProductsFromFile();
        updateUsersTableView();
    }

    @Override
    protected void handleLogout(ActionEvent event) {
        LoginViewController loginParent = new LoginViewController();
        Scene loginScene = new Scene(loginParent);
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    @Override
    protected void handleTransactionDelete(ActionEvent event) {
        if (tvTransactions.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting bill!");
            alert.setContentText("Please ensure a bill is selected to be removed.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Confirm Delete");
            alert.setContentText("Are you sure you wish to delete the bill?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Bill bill = (Bill) tvTransactions.getSelectionModel().getSelectedItem();
                deleteBill(bill);
                writeTransactionsToFile();
                updateBillTableView();
            }
        }
    }

    @Override
    protected void handleModifyTransaction(ActionEvent event) {
        if (tvTransactions.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error updating bill!");
            alert.setContentText("Please ensure a bill is selected to be updated.");
            alert.showAndWait();
        } else {
            Bill modifyBill = (Bill) tvTransactions.getSelectionModel().getSelectedItem();
            modifyBillIndex = getAllBills().indexOf(modifyBill);
            ModifyBillController modifyBillParent = new ModifyBillController(user, modifyBill.getName(), modifyBill.getPrice(), modifyBill.getQuantity());
            Scene modifyBillScene = new Scene(modifyBillParent);
            Stage modifyBillStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyBillStage.setScene(modifyBillScene);
            modifyBillStage.show();
        }
    }

    @Override
    protected void handleTransactionAdd(ActionEvent event) {
        AddTransactionController addBillParent = new AddTransactionController(user);

        Scene addBillScene = new Scene(addBillParent);
        Stage addBillStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addBillStage.setScene(addBillScene);
        addBillStage.show();
    }

    @Override
    protected void handleTransactionSearch(ActionEvent event) {
        String search = txtTransactionSearch.getText();
        int billIndex = -1;
        if("".equals(search)){
            readAllTransactionsFromFile();
            return;
        }
        if (Bill.lookupTransaction(search) == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Error");
            alert.setHeaderText("Bill not found!");
            alert.setContentText("Search term does not match any known bills.");
            alert.showAndWait();
        } else {
            billIndex = lookupTransaction(search);
            Bill tempBill = getAllBills().get(billIndex);
            ObservableList<Bill> tempBillList = FXCollections.observableArrayList();
            tempBillList.add(tempBill);
            tvTransactions.setItems(tempBillList);

        }

    }
    
    private void readAllTransactionsFromFile() {
        try {
            File uf = new File("src/resources/transactions.ser");
            FileInputStream file = new FileInputStream(uf);
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream input = new ObjectInputStream(buffer);
            
            ArrayList<Bill> list = (ArrayList<Bill>) input.readObject();
            allBills = FXCollections.observableList(list);
            updateBillTableView();
            file.close();
            buffer.close();
            input.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateBillTableView();
    }

    public static void writeTransactionsToFile() {
        try {            
            File f = new File("src/resources/transactions.ser");
            FileOutputStream fl = new FileOutputStream(f);
            BufferedOutputStream bf = new BufferedOutputStream(fl);
            ObjectOutput output = new ObjectOutputStream(bf);
            output.writeObject(new ArrayList<Bill>(allBills));
            bf.close();
            fl.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform output." + ex.toString());
        }
    }

    private void readAllProductsFromFile() {
        try {
            File uf = new File("src/resources/products.ser");
            FileInputStream file = new FileInputStream(uf);
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream input = new ObjectInputStream(buffer);
            
            ArrayList<Product> list = (ArrayList<Product>) input.readObject();
            allProducts = FXCollections.observableList(list);
            updateProductsTableView();
            file.close();
            buffer.close();
            input.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeProductsToFile() {
        try {            
            File f = new File("src/resources/products.ser");
            FileOutputStream fl = new FileOutputStream(f);
            BufferedOutputStream bf = new BufferedOutputStream(fl);
            ObjectOutput output = new ObjectOutputStream(bf);
            output.writeObject(new ArrayList<Product>(allProducts));
            bf.close();
            fl.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform output." + ex.toString());
        }
    }

    //Update table views
    public void updateBillTableView() {
        tvTransactions.setItems(allBills);
    }

    //Update table views
    public void updateProductsTableView() {
        tvProducts.setItems(allProducts);
    }

    public void updateUsersTableView() {
        tvEmployees.setItems(allUsers);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    protected void handleProductsSearch(ActionEvent actionEvent) {
        String search = txtProductsSearch.getText();
        int productIndex = -1;
        if("".equals(search)){
            readAllProductsFromFile();
            return;
        }
        productIndex = lookupProduct(search);
        if (productIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Error");
            alert.setHeaderText("Product not found!");
            alert.setContentText("Search term does not match any known products.");
            alert.showAndWait();
        } else {
            Product tempP = allProducts.get(productIndex);
            ObservableList<Product> tempList = FXCollections.observableArrayList();
            tempList.add(tempP);
            tvProducts.setItems(tempList);

        }
    }

    @Override
    protected void handleProductsAdd(ActionEvent actionEvent) {
        AddProductController addProductParent = new AddProductController(user);

        Scene addProductScene = new Scene(addProductParent);
        Stage addProductStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        addProductStage.setScene(addProductScene);
        addProductStage.show();
    }

    @Override
    protected void handleProductsDelete(ActionEvent actionEvent) {
        if (tvProducts.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting product!");
            alert.setContentText("Please ensure a product is selected to be removed.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Confirm Delete");
            alert.setContentText("Are you sure you wish to delete the product?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Product p = (Product) tvProducts.getSelectionModel().getSelectedItem();
                deleteProduct(p);
                writeProductsToFile();
                updateProductsTableView();
            }
        }
    }

    @Override
    protected void handleProductsModify(ActionEvent actionEvent) {
        if (tvProducts.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error updating bill!");
            alert.setContentText("Please ensure a bill is selected to be updated.");
            alert.showAndWait();
        } else {
            Product modifyProduct = (Product) tvProducts.getSelectionModel().getSelectedItem();
            modifyProductIndex = allProducts.indexOf(modifyProduct);
            ModifyProductController modifyProductParent = new ModifyProductController(user, modifyProduct.getCategory(), modifyProduct.getName(), modifyProduct.getPrice(), modifyProduct.getQuantity());
            Scene modifyProductScene = new Scene(modifyProductParent);
            Stage modifyProductStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            modifyProductStage.setScene(modifyProductScene);
            modifyProductStage.show();
        }
    }

    @Override
    protected void handleEmployeeSearch(ActionEvent actionEvent) {
        String search = txtEmployeeSearch.getText();
        int userIndex = -1;
        if("".equals(search)){
            readAllUsersFromFile();
            updateUsersTableView();
            return;
        }
        
        userIndex=lookupUser(search);
        
        if (userIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Error");
            alert.setHeaderText("User not found!");
            alert.setContentText("Search term does not match any known users.");
            alert.showAndWait();
        } else {
            User tempU = allUsers.get(userIndex);
            ObservableList<User> tempUserList = FXCollections.observableArrayList();
            tempUserList.add(tempU);
            tvEmployees.setItems(tempUserList);
        }
    }

    @Override
    protected void handleEmployeeAdd(ActionEvent actionEvent) {
        AddUsersController addUserParent = new AddUsersController(user);

        Scene addUserScene = new Scene(addUserParent);
        Stage addUserStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        addUserStage.setScene(addUserScene);
        addUserStage.show();
    }

    @Override
    protected void handleEmployeeModify(ActionEvent actionEvent) {
        if (tvEmployees.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error updating user!");
            alert.setContentText("Please ensure a user is selected to be updated.");
            alert.showAndWait();
        } else {
            User modifyUser = (User) tvEmployees.getSelectionModel().getSelectedItem();
            modifyUserIndex = allUsers.indexOf(modifyUser);
            ModifyUserController modifyUserParent = new ModifyUserController(user, modifyUser);
            Scene modifyUserScene = new Scene(modifyUserParent);
            Stage modifyUserStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            modifyUserStage.setScene(modifyUserScene);
            modifyUserStage.show();
        }
    }

    @Override
    protected void handleEmployeeDelete(ActionEvent actionEvent) {
        if (tvEmployees.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting user!");
            alert.setContentText("Please ensure a user is selected to be removed.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Confirm Delete");
            alert.setContentText("Are you sure you wish to delete the user?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                User u = (User) tvEmployees.getSelectionModel().getSelectedItem();
                deleteUser(u);
                writeUsersToFile();
                updateUsersTableView();
            }
        }
    }

    public static ArrayList<Date> getThisWeekDates(){
        ArrayList<Date> days = new ArrayList<>();
        Date today= new Date();
        int t = today.getDay();
        for (int i=t; i>0; i--){
            Date newDate = new Date();
            newDate.setDate(i);
            days.add(newDate);
        }
        return days;
    }
    
    public static Boolean dateFound(Date d, ArrayList<Date> dates){
        for(Date dt : dates){
            if (dt.getDate()==d.getDate() && dt.getYear()==d.getYear() && dt.getMonth()==d.getMonth()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void handleGenerateStatistics(ActionEvent actionEvent) {
        double total=0;
        double thisWeekTotal=0;
        ArrayList<Date> thisWeekDays = getThisWeekDates();
        for(int i=0; i<allBills.size();i++){
            if (dateFound(allBills.get(i).getDate(), thisWeekDays)){
                thisWeekTotal += allBills.get(i).getTotal();
            }
            total += allBills.get(i).getTotal();
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Status");
        alert.setHeaderText("Total amount made" );
        alert.setContentText("Total: " + total + "\n " + "Total made this week: " + thisWeekTotal);
        alert.showAndWait();
    }

    @Override
    protected void handleGenerateProductsStatistics(ActionEvent actionEvent) {
        double total=0;
        double thisWeekTotal=0;
        ArrayList<Date> thisWeekDays = getThisWeekDates();
        for(int i=0; i<allProducts.size();i++){
            if (dateFound(allProducts.get(i).getDate(), thisWeekDays)){
                thisWeekTotal += allProducts.get(i).getPrice() * allProducts.get(i).getQuantity();
            }
            total += allProducts.get(i).getPrice() * allProducts.get(i).getQuantity();
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Status");
        alert.setHeaderText("Total amount spent" );
        alert.setContentText("Total: " + total + "\n " + "Total spent this week: " + thisWeekTotal);
        alert.showAndWait();
    }
    

}
