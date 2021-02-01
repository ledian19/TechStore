package TechStore.Controller;

import TechStore.Model.Bill;
import static TechStore.Model.Bill.allBills;
import static TechStore.Model.Bill.deleteBill;
import static TechStore.Model.Bill.getAllBills;
import static TechStore.Model.Bill.lookupTransaction;
import TechStore.Model.Product;
import static TechStore.Model.Product.allProducts;
import TechStore.Model.User;
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

    public static final String pathName = "src/resources/transactions.ser";
    
    public static Bill modifyBill;
    public static int modifyBillIndex;
    private User user;

    public MainPageController(User user) {
        super(user.getUserLevel());
        this.user = user;
        billTotalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        billProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        billPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        billQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        productsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        
        readAllTransactionsFromFile();
        readAllProductsFromFile();
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
            modifyBill = (Bill) tvTransactions.getSelectionModel().getSelectedItem();
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
            File uf = new File(pathName);
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
            File f = new File(pathName);
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
            updateBillTableView();
            file.close();
            buffer.close();
            input.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateProductsTableView();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    protected void handleGenerateStatistics(ActionEvent actionEvent) {
        double total=0;
        String user="";
        for(int i=0; i<allBills.size();i++){
            user=allBills.get(i).getUsername();
            if ("admin".equals(user)){
                total += allBills.get(i).getTotal();
            }
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Status");
        alert.setHeaderText("Total amount made" );
        alert.setContentText("Total: " + total);
        alert.showAndWait();
    }

    @Override
    protected void handleProductsSearch(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleProductsModify(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleEmployeeSearch(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleEmployeeAdd(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleEmployeeModify(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleEmployeeDelete(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
