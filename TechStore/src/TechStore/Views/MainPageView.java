package TechStore.Views;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class MainPageView extends AnchorPane {

    protected final TabPane tabPane;
    protected final Tab trxTab;
    protected final AnchorPane anchorPane;
    protected final AnchorPane transactionsAnchor;
    protected final Label lblProducts1;
    protected final TableView tvTransactions;
    protected final TableColumn billProductNameColumn;
    protected final TableColumn billPriceColumn;
    protected final TableColumn billQuantityColumn;
    protected final TableColumn billTotalColumn;
    protected final TextField txtTransactionSearch;
    protected final Button btnProductsSearch1;
    protected final ButtonBar buttonBar;
    protected final Button btnAddTransaction;
    protected final Button btnModifyTransaction;
    protected final Button btnTransactionDelete;
    protected final Button btnGenerateStatistics;
    protected final Tab productsTab;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane productsAnchor;
    protected final Label lblParts;
    protected final TableView tvProducts;
    protected final TableColumn productCategoryColumn;
    protected final TableColumn productsNameColumn;
    protected final TableColumn productPriceColumn;
    protected final TableColumn productStockColumn;
    protected final TextField txtProductsSearch;
    protected final Button btnProductsSearch;
    protected final Button btnProductsAdd;
    protected final Button btnPartDelete;
    protected final Button btnProductsModify;
    protected final Button btnGenerateProductsStatistics;
    protected final Tab usersTab;
    protected final AnchorPane anchorPane1;
    protected final AnchorPane employeesAnchor;
    protected final Label lblProducts;
    protected final TableView tvEmployees;
    protected final TableColumn employeeUsernameColumn;
    protected final TableColumn employeeNameColumn;
    protected final TableColumn employeeRoleColumn;
    protected final TableColumn employeeSalaryColumn;
    protected final TableColumn employeePhoneColumn;
    protected final TableColumn employeeEmailColumn;
    protected final TableColumn employeeBirthdayColumn;
    protected final TextField txtEmployeeSearch;
    protected final Button btnEmployeesSearch;
    protected final Button btnEmployeeAdd;
    protected final Button btnEmployeeModify;
    protected final Button btnEmployeeDelete;
    protected final Label label;
    protected final Button btnLogout;

    public MainPageView(int userLevel) {

        tabPane = new TabPane();
        trxTab = new Tab();
        anchorPane = new AnchorPane();
        transactionsAnchor = new AnchorPane();
        lblProducts1 = new Label();
        tvTransactions = new TableView();
        billProductNameColumn = new TableColumn();
        billPriceColumn = new TableColumn();
        billQuantityColumn = new TableColumn();
        billTotalColumn = new TableColumn();
        txtTransactionSearch = new TextField();
        btnProductsSearch1 = new Button();
        buttonBar = new ButtonBar();
        btnAddTransaction = new Button();
        btnModifyTransaction = new Button();
        btnTransactionDelete = new Button();
        btnGenerateStatistics = new Button();
        productsTab = new Tab();
        anchorPane0 = new AnchorPane();
        productsAnchor = new AnchorPane();
        lblParts = new Label();
        tvProducts = new TableView();
        productCategoryColumn = new TableColumn();
        productsNameColumn = new TableColumn();
        productPriceColumn = new TableColumn();
        productStockColumn = new TableColumn();
        txtProductsSearch = new TextField();
        btnProductsSearch = new Button();
        btnProductsAdd = new Button();
        btnPartDelete = new Button();
        btnProductsModify = new Button();
        btnGenerateProductsStatistics = new Button();
        usersTab = new Tab();
        anchorPane1 = new AnchorPane();
        employeesAnchor = new AnchorPane();
        lblProducts = new Label();
        tvEmployees = new TableView();
        employeeUsernameColumn = new TableColumn();
        employeeNameColumn = new TableColumn();
        employeeRoleColumn = new TableColumn();
        employeeSalaryColumn = new TableColumn();
        employeePhoneColumn = new TableColumn();
        employeeEmailColumn = new TableColumn();
        employeeBirthdayColumn = new TableColumn();
        txtEmployeeSearch = new TextField();
        btnEmployeesSearch = new Button();
        btnEmployeeAdd = new Button();
        btnEmployeeModify = new Button();
        btnEmployeeDelete = new Button();
        label = new Label();
        btnLogout = new Button();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(1123.0);

        tabPane.setLayoutX(25.0);
        tabPane.setLayoutY(75.0);
        tabPane.setPrefHeight(395.0);
        tabPane.setPrefWidth(1080.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        trxTab.setText("Transactions");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(732.0);
        anchorPane.setPrefWidth(1058.0);

        transactionsAnchor.setLayoutX(7.0);
        transactionsAnchor.setLayoutY(21.0);
        transactionsAnchor.setPrefHeight(353.0);
        transactionsAnchor.setPrefWidth(1060.0);
        transactionsAnchor.setStyle("-fx-background-color: white;");

        lblProducts1.setLayoutX(14.0);
        lblProducts1.setLayoutY(14.0);
        lblProducts1.setText("Transactions");

        tvTransactions.setLayoutY(39.0);
        tvTransactions.setPrefHeight(212.0);
        tvTransactions.setPrefWidth(1038.0);

        billProductNameColumn.setPrefWidth(75.0);
        billProductNameColumn.setText("Product Name");

        billPriceColumn.setPrefWidth(75.0);
        billPriceColumn.setText("Price");

        billQuantityColumn.setPrefWidth(75.0);
        billQuantityColumn.setText("Quantity");

        billTotalColumn.setPrefWidth(75.0);
        billTotalColumn.setText("Total");
        tvTransactions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        txtTransactionSearch.setLayoutX(817.0);
        txtTransactionSearch.setLayoutY(9.0);
        txtTransactionSearch.setPrefHeight(25.0);
        txtTransactionSearch.setPrefWidth(222.0);

        btnProductsSearch1.setLayoutX(748.0);
        btnProductsSearch1.setLayoutY(9.0);
        btnProductsSearch1.setMnemonicParsing(false);
        btnProductsSearch1.setOnAction(this::handleTransactionSearch);
        btnProductsSearch1.setText("Search");

        buttonBar.setLayoutX(212.0);
        buttonBar.setLayoutY(205.0);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);

        btnAddTransaction.setLayoutX(790.0);
        btnAddTransaction.setLayoutY(280.0);
        btnAddTransaction.setMnemonicParsing(false);
        btnAddTransaction.setOnAction(this::handleTransactionAdd);
        btnAddTransaction.setText("Add");

        btnModifyTransaction.setLayoutX(865.0);
        btnModifyTransaction.setLayoutY(280.0);
        btnModifyTransaction.setMnemonicParsing(false);
        btnModifyTransaction.setOnAction(this::handleModifyTransaction);
        btnModifyTransaction.setText("Modify");

        btnTransactionDelete.setLayoutX(954.0);
        btnTransactionDelete.setLayoutY(280.0);
        btnTransactionDelete.setMnemonicParsing(false);
        btnTransactionDelete.setOnAction(this::handleTransactionDelete);
        btnTransactionDelete.setText("Delete");

        btnGenerateStatistics.setLayoutX(649.0);
        btnGenerateStatistics.setLayoutY(280.0);
        btnGenerateStatistics.setMnemonicParsing(false);
        btnGenerateStatistics.setOnAction(this::handleGenerateStatistics);
        btnGenerateStatistics.setText("Generate Statistics");
        trxTab.setContent(anchorPane);

        productsTab.setText("Products");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        productsAnchor.setLayoutY(14.0);
        productsAnchor.setPrefHeight(370.0);
        productsAnchor.setPrefWidth(1080.0);
        productsAnchor.setStyle("-fx-background-color: white;");

        lblParts.setLayoutX(14.0);
        lblParts.setLayoutY(14.0);
        lblParts.setPrefHeight(17.0);
        lblParts.setPrefWidth(54.0);
        lblParts.setText("Products");

        tvProducts.setLayoutX(6.0);
        tvProducts.setLayoutY(39.0);
        tvProducts.setPrefHeight(212.0);
        tvProducts.setPrefWidth(1073.0);

        productCategoryColumn.setPrefWidth(75.0);
        productCategoryColumn.setText("Category");

        productsNameColumn.setPrefWidth(75.0);
        productsNameColumn.setText("Product Name");

        productPriceColumn.setPrefWidth(75.0);
        productPriceColumn.setText("Product Price");

        productStockColumn.setPrefWidth(75.0);
        productStockColumn.setText("Stock");
        tvProducts.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        txtProductsSearch.setLayoutX(818.0);
        txtProductsSearch.setLayoutY(9.0);
        txtProductsSearch.setPrefHeight(25.0);
        txtProductsSearch.setPrefWidth(248.0);

        btnProductsSearch.setLayoutX(749.0);
        btnProductsSearch.setLayoutY(9.0);
        btnProductsSearch.setMnemonicParsing(false);
        btnProductsSearch.setOnAction(this::handleProductsSearch);
        btnProductsSearch.setText("Search");

        btnProductsAdd.setLayoutX(848.0);
        btnProductsAdd.setLayoutY(290.0);
        btnProductsAdd.setMnemonicParsing(false);
        btnProductsAdd.setOnAction(this::handleProductsAdd);
        btnProductsAdd.setText("Add");

        btnPartDelete.setLayoutX(1012.0);
        btnPartDelete.setLayoutY(290.0);
        btnPartDelete.setMnemonicParsing(false);
        btnPartDelete.setOnAction(this::handleProductsDelete);
        btnPartDelete.setText("Delete");

        btnProductsModify.setLayoutX(926.0);
        btnProductsModify.setLayoutY(290.0);
        btnProductsModify.setMnemonicParsing(false);
        btnProductsModify.setOnAction(this::handleProductsModify);
        btnProductsModify.setText("Modify");

        btnGenerateProductsStatistics.setLayoutX(694.0);
        btnGenerateProductsStatistics.setLayoutY(290.0);
        btnGenerateProductsStatistics.setMnemonicParsing(false);
        btnGenerateProductsStatistics.setOnAction(this::handleGenerateProductsStatistics);
        btnGenerateProductsStatistics.setText("Generate Statistics");
        productsTab.setContent(anchorPane0);

        usersTab.setText("Users");

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(362.0);
        anchorPane1.setPrefWidth(1092.0);

        employeesAnchor.setLayoutY(14.0);
        employeesAnchor.setPrefHeight(332.0);
        employeesAnchor.setPrefWidth(1080.0);
        employeesAnchor.setStyle("-fx-background-color: white;");

        lblProducts.setLayoutX(14.0);
        lblProducts.setLayoutY(14.0);
        lblProducts.setText("Employees");

        tvEmployees.setLayoutX(7.0);
        tvEmployees.setLayoutY(39.0);
        tvEmployees.setPrefHeight(212.0);
        tvEmployees.setPrefWidth(1052.0);

        employeeUsernameColumn.setPrefWidth(75.0);
        employeeUsernameColumn.setText("Username");

        employeeNameColumn.setPrefWidth(75.0);
        employeeNameColumn.setText("Full Name");

        employeeRoleColumn.setPrefWidth(75.0);
        employeeRoleColumn.setText("Role");

        employeeSalaryColumn.setPrefWidth(75.0);
        employeeSalaryColumn.setText("Salary");

        employeePhoneColumn.setPrefWidth(75.0);
        employeePhoneColumn.setText("Phone");

        employeeEmailColumn.setPrefWidth(75.0);
        employeeEmailColumn.setText("Email");

        employeeBirthdayColumn.setPrefWidth(75.0);
        employeeBirthdayColumn.setText("Birthday");
        tvEmployees.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        txtEmployeeSearch.setLayoutX(837.0);
        txtEmployeeSearch.setLayoutY(9.0);
        txtEmployeeSearch.setPrefHeight(25.0);
        txtEmployeeSearch.setPrefWidth(222.0);

        btnEmployeesSearch.setLayoutX(768.0);
        btnEmployeesSearch.setLayoutY(9.0);
        btnEmployeesSearch.setMnemonicParsing(false);
        btnEmployeesSearch.setOnAction(this::handleEmployeeSearch);
        btnEmployeesSearch.setText("Search");

        btnEmployeeAdd.setLayoutX(825.0);
        btnEmployeeAdd.setLayoutY(273.0);
        btnEmployeeAdd.setMnemonicParsing(false);
        btnEmployeeAdd.setOnAction(this::handleEmployeeAdd);
        btnEmployeeAdd.setText("Add");

        btnEmployeeModify.setLayoutX(910.0);
        btnEmployeeModify.setLayoutY(273.0);
        btnEmployeeModify.setMnemonicParsing(false);
        btnEmployeeModify.setOnAction(this::handleEmployeeModify);
        btnEmployeeModify.setText("Modify");

        btnEmployeeDelete.setLayoutX(995.0);
        btnEmployeeDelete.setLayoutY(273.0);
        btnEmployeeDelete.setMnemonicParsing(false);
        btnEmployeeDelete.setOnAction(this::handleEmployeeDelete);
        btnEmployeeDelete.setText("Delete");
        usersTab.setContent(anchorPane1);

        label.setLayoutX(50.0);
        label.setLayoutY(21.0);
        label.setPrefHeight(40.0);
        label.setPrefWidth(269.0);
        label.setStyle("-fx-font-weight: bold;");
        label.setText("TechStore Management System");
        label.setFont(new Font(18.0));

        btnLogout.setLayoutX(971.0);
        btnLogout.setLayoutY(21.0);
        btnLogout.setMnemonicParsing(false);
        btnLogout.setOnAction(this::handleLogout);
        btnLogout.setPrefHeight(40.0);
        btnLogout.setPrefWidth(107.0);
        btnLogout.setText("Log out");
        btnLogout.setFont(new Font("Calibri Bold", 18.0));

        transactionsAnchor.getChildren().add(lblProducts1);
        tvTransactions.getColumns().add(billProductNameColumn);
        tvTransactions.getColumns().add(billPriceColumn);
        tvTransactions.getColumns().add(billQuantityColumn);
        tvTransactions.getColumns().add(billTotalColumn);
        transactionsAnchor.getChildren().add(tvTransactions);
        transactionsAnchor.getChildren().add(txtTransactionSearch);
        transactionsAnchor.getChildren().add(btnProductsSearch1);
        transactionsAnchor.getChildren().add(buttonBar);
        transactionsAnchor.getChildren().add(btnAddTransaction);
        transactionsAnchor.getChildren().add(btnModifyTransaction);
        transactionsAnchor.getChildren().add(btnTransactionDelete);
        transactionsAnchor.getChildren().add(btnGenerateStatistics);
        anchorPane.getChildren().add(transactionsAnchor);
        productsAnchor.getChildren().add(lblParts);
        tvProducts.getColumns().add(productCategoryColumn);
        tvProducts.getColumns().add(productsNameColumn);
        tvProducts.getColumns().add(productPriceColumn);
        tvProducts.getColumns().add(productStockColumn);
        productsAnchor.getChildren().add(tvProducts);
        productsAnchor.getChildren().add(txtProductsSearch);
        productsAnchor.getChildren().add(btnProductsSearch);
        productsAnchor.getChildren().add(btnProductsAdd);
        productsAnchor.getChildren().add(btnPartDelete);
        productsAnchor.getChildren().add(btnProductsModify);
        productsAnchor.getChildren().add(btnGenerateProductsStatistics);
        anchorPane0.getChildren().add(productsAnchor);
        employeesAnchor.getChildren().add(lblProducts);
        tvEmployees.getColumns().add(employeeUsernameColumn);
        tvEmployees.getColumns().add(employeeNameColumn);
        tvEmployees.getColumns().add(employeeRoleColumn);
        tvEmployees.getColumns().add(employeeSalaryColumn);
        tvEmployees.getColumns().add(employeePhoneColumn);
        tvEmployees.getColumns().add(employeeEmailColumn);
        tvEmployees.getColumns().add(employeeBirthdayColumn);
        employeesAnchor.getChildren().add(tvEmployees);
        employeesAnchor.getChildren().add(txtEmployeeSearch);
        employeesAnchor.getChildren().add(btnEmployeesSearch);
        employeesAnchor.getChildren().add(btnEmployeeAdd);
        employeesAnchor.getChildren().add(btnEmployeeModify);
        employeesAnchor.getChildren().add(btnEmployeeDelete);
        anchorPane1.getChildren().add(employeesAnchor);
        
        tabPane.getTabs().add(trxTab);
        if (userLevel==1){
            tabPane.getTabs().add(productsTab);
            tabPane.getTabs().add(usersTab);
        }
        else if (userLevel==2){
            tabPane.getTabs().add(productsTab);
        }

        getChildren().add(tabPane);
        getChildren().add(label);
        getChildren().add(btnLogout);

    }

    protected abstract void handleTransactionSearch(javafx.event.ActionEvent actionEvent);

    protected abstract void handleTransactionAdd(javafx.event.ActionEvent actionEvent);

    protected abstract void handleModifyTransaction(javafx.event.ActionEvent actionEvent);

    protected abstract void handleTransactionDelete(javafx.event.ActionEvent actionEvent);

    protected abstract void handleGenerateStatistics(javafx.event.ActionEvent actionEvent);

    protected abstract void handleProductsSearch(javafx.event.ActionEvent actionEvent);

    protected abstract void handleProductsAdd(javafx.event.ActionEvent actionEvent);

    protected abstract void handleProductsDelete(javafx.event.ActionEvent actionEvent);

    protected abstract void handleProductsModify(javafx.event.ActionEvent actionEvent);

    protected abstract void handleGenerateProductsStatistics(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeSearch(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeAdd(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeModify(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeDelete(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLogout(javafx.event.ActionEvent actionEvent);

}
