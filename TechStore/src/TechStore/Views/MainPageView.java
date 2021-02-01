package TechStore.Views;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class MainPageView extends AnchorPane {

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
    protected final AnchorPane productsAnchor;
    protected final Label lblParts;
    protected final TableView tvProducts;
    protected final TableColumn productIdColumn;
    protected final TableColumn productsNameColumn;
    protected final TableColumn productPriceColumn;
    protected final TableColumn productStockColumn;
    protected final TextField txtProductsSearch;
    protected final Button btnProductsSearch;
    protected final ButtonBar buttonBar0;
    protected final Button btnProductsAdd;
    protected final Button btnPartDelete;
    protected final Button btnProductsModify;
    protected final Label label;
    protected final AnchorPane employeesAnchor;
    protected final Label lblProducts;
    protected final TableView tvEmployees;
    protected final TableColumn employeeIdColumn;
    protected final TableColumn employeeNameColumn;
    protected final TableColumn employeeRoleColumn;
    protected final TableColumn employeeSalaryColumn;
    protected final TableColumn employeePhoneColumn;
    protected final TableColumn employeeEmailColumn;
    protected final TableColumn employeeBirthdayColumn;
    protected final TextField txtEmployeeSearch;
    protected final Button btnEmployeesSearch;
    protected final ButtonBar buttonBar1;
    protected final Button btnEmployeeAdd;
    protected final Button btnEmployeeModify;
    protected final Button btnEmployeeDelete;
    protected final Button btnLogout;

    public MainPageView(int userLevel) {

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
        productsAnchor = new AnchorPane();
        lblParts = new Label();
        tvProducts = new TableView();
        productIdColumn = new TableColumn();
        productsNameColumn = new TableColumn();
        productPriceColumn = new TableColumn();
        productStockColumn = new TableColumn();
        txtProductsSearch = new TextField();
        btnProductsSearch = new Button();
        buttonBar0 = new ButtonBar();
        btnProductsAdd = new Button();
        btnPartDelete = new Button();
        btnProductsModify = new Button();
        label = new Label();
        employeesAnchor = new AnchorPane();
        lblProducts = new Label();
        tvEmployees = new TableView();
        employeeIdColumn = new TableColumn();
        employeeNameColumn = new TableColumn();
        employeeRoleColumn = new TableColumn();
        employeeSalaryColumn = new TableColumn();
        employeePhoneColumn = new TableColumn();
        employeeEmailColumn = new TableColumn();
        employeeBirthdayColumn = new TableColumn();
        txtEmployeeSearch = new TextField();
        btnEmployeesSearch = new Button();
        buttonBar1 = new ButtonBar();
        btnEmployeeAdd = new Button();
        btnEmployeeModify = new Button();
        btnEmployeeDelete = new Button();
        btnLogout = new Button();

        setId("AnchorPane");
        setPrefHeight(870.0);
        setPrefWidth(1123.0);

        transactionsAnchor.setLayoutX(48.0);
        transactionsAnchor.setLayoutY(85.0);
        transactionsAnchor.setPrefHeight(332.0);
        transactionsAnchor.setPrefWidth(1030.0);
        transactionsAnchor.setStyle("-fx-background-color: white;");

        lblProducts1.setLayoutX(14.0);
        lblProducts1.setLayoutY(14.0);
        lblProducts1.setText("Transactions");

        tvTransactions.setLayoutX(14.0);
        tvTransactions.setLayoutY(39.0);
        tvTransactions.setPrefHeight(212.0);
        tvTransactions.setPrefWidth(996.0);

        billTotalColumn.setPrefWidth(75.0);
        billTotalColumn.setText("Total");

        billProductNameColumn.setPrefWidth(75.0);
        billProductNameColumn.setText("Product Name");

        billPriceColumn.setPrefWidth(75.0);
        billPriceColumn.setText("Price");

        billQuantityColumn.setPrefWidth(75.0);
        billQuantityColumn.setText("Quantity");
        tvTransactions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        txtTransactionSearch.setLayoutX(789.0);
        txtTransactionSearch.setLayoutY(10.0);
        txtTransactionSearch.setPrefHeight(25.0);
        txtTransactionSearch.setPrefWidth(222.0);

        btnProductsSearch1.setLayoutX(720.0);
        btnProductsSearch1.setLayoutY(10.0);
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

        productsAnchor.setLayoutX(50.0);
        productsAnchor.setLayoutY(454.0);
        productsAnchor.setPrefHeight(332.0);
        productsAnchor.setPrefWidth(495.0);
        productsAnchor.setStyle("-fx-background-color: white;");

        lblParts.setLayoutX(14.0);
        lblParts.setLayoutY(14.0);
        lblParts.setPrefHeight(17.0);
        lblParts.setPrefWidth(54.0);
        lblParts.setText("Products");

        tvProducts.setLayoutX(14.0);
        tvProducts.setLayoutY(39.0);
        tvProducts.setPrefHeight(212.0);
        tvProducts.setPrefWidth(463.0);

        productIdColumn.setPrefWidth(75.0);
        productIdColumn.setText("Product ID");

        productsNameColumn.setPrefWidth(75.0);
        productsNameColumn.setText("Product Name");

        productPriceColumn.setPrefWidth(75.0);
        productPriceColumn.setText("Product Price");

        productStockColumn.setPrefWidth(75.0);
        productStockColumn.setText("Stock");
        tvProducts.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        txtProductsSearch.setLayoutX(229.0);
        txtProductsSearch.setLayoutY(10.0);
        txtProductsSearch.setPrefHeight(25.0);
        txtProductsSearch.setPrefWidth(248.0);

        btnProductsSearch.setLayoutX(160.0);
        btnProductsSearch.setLayoutY(10.0);
        btnProductsSearch.setMnemonicParsing(false);
        btnProductsSearch.setOnAction(this::handleProductsSearch);
        btnProductsSearch.setText("Search");

        buttonBar0.setLayoutX(212.0);
        buttonBar0.setLayoutY(205.0);
        buttonBar0.setPrefHeight(40.0);
        buttonBar0.setPrefWidth(200.0);

        btnProductsAdd.setLayoutX(248.0);
        btnProductsAdd.setLayoutY(293.0);
        btnProductsAdd.setMnemonicParsing(false);
        btnProductsAdd.setOnAction(this::handleProductsAdd);
        btnProductsAdd.setText("Add");

        btnPartDelete.setLayoutX(412.0);
        btnPartDelete.setLayoutY(293.0);
        btnPartDelete.setMnemonicParsing(false);
        btnPartDelete.setOnAction(this::handleProductsDelete);
        btnPartDelete.setText("Delete");

        btnProductsModify.setLayoutX(326.0);
        btnProductsModify.setLayoutY(293.0);
        btnProductsModify.setMnemonicParsing(false);
        btnProductsModify.setOnAction(this::handleProductsModify);
        btnProductsModify.setText("Modify");

        label.setLayoutX(50.0);
        label.setLayoutY(21.0);
        label.setPrefHeight(40.0);
        label.setPrefWidth(269.0);
        label.setStyle("-fx-font-weight: bold;");
        label.setText("TechStore Management System");
        label.setFont(new Font(18.0));

        employeesAnchor.setLayoutX(580.0);
        employeesAnchor.setLayoutY(454.0);
        employeesAnchor.setPrefHeight(332.0);
        employeesAnchor.setPrefWidth(495.0);
        employeesAnchor.setStyle("-fx-background-color: white;");

        lblProducts.setLayoutX(14.0);
        lblProducts.setLayoutY(14.0);
        lblProducts.setText("Employees");

        tvEmployees.setLayoutX(14.0);
        tvEmployees.setLayoutY(39.0);
        tvEmployees.setPrefHeight(212.0);
        tvEmployees.setPrefWidth(463.0);

        employeeIdColumn.setPrefWidth(75.0);
        employeeIdColumn.setText("E.ID");

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

        txtEmployeeSearch.setLayoutX(255.0);
        txtEmployeeSearch.setLayoutY(10.0);
        txtEmployeeSearch.setPrefHeight(25.0);
        txtEmployeeSearch.setPrefWidth(222.0);

        btnEmployeesSearch.setLayoutX(186.0);
        btnEmployeesSearch.setLayoutY(10.0);
        btnEmployeesSearch.setMnemonicParsing(false);
        btnEmployeesSearch.setOnAction(this::handleEmployeeSearch);
        btnEmployeesSearch.setText("Search");

        buttonBar1.setLayoutX(212.0);
        buttonBar1.setLayoutY(205.0);
        buttonBar1.setPrefHeight(40.0);
        buttonBar1.setPrefWidth(200.0);

        btnEmployeeAdd.setLayoutX(251.0);
        btnEmployeeAdd.setLayoutY(293.0);
        btnEmployeeAdd.setMnemonicParsing(false);
        btnEmployeeAdd.setOnAction(this::handleEmployeeAdd);
        btnEmployeeAdd.setText("Add");

        btnEmployeeModify.setLayoutX(336.0);
        btnEmployeeModify.setLayoutY(293.0);
        btnEmployeeModify.setMnemonicParsing(false);
        btnEmployeeModify.setOnAction(this::handleEmployeeModify);
        btnEmployeeModify.setText("Modify");

        btnEmployeeDelete.setLayoutX(421.0);
        btnEmployeeDelete.setLayoutY(293.0);
        btnEmployeeDelete.setMnemonicParsing(false);
        btnEmployeeDelete.setOnAction(this::handleEmployeeDelete);
        btnEmployeeDelete.setText("Delete");

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
        productsAnchor.getChildren().add(lblParts);
        tvProducts.getColumns().add(productIdColumn);
        tvProducts.getColumns().add(productsNameColumn);
        tvProducts.getColumns().add(productPriceColumn);
        tvProducts.getColumns().add(productStockColumn);
        productsAnchor.getChildren().add(tvProducts);
        productsAnchor.getChildren().add(txtProductsSearch);
        productsAnchor.getChildren().add(btnProductsSearch);
        productsAnchor.getChildren().add(buttonBar0);
        productsAnchor.getChildren().add(btnProductsAdd);
        productsAnchor.getChildren().add(btnPartDelete);
        productsAnchor.getChildren().add(btnProductsModify);
        employeesAnchor.getChildren().add(lblProducts);
        tvEmployees.getColumns().add(employeeIdColumn);
        tvEmployees.getColumns().add(employeeNameColumn);
        tvEmployees.getColumns().add(employeeRoleColumn);
        tvEmployees.getColumns().add(employeeSalaryColumn);
        tvEmployees.getColumns().add(employeePhoneColumn);
        tvEmployees.getColumns().add(employeeEmailColumn);
        tvEmployees.getColumns().add(employeeBirthdayColumn);
        employeesAnchor.getChildren().add(tvEmployees);
        employeesAnchor.getChildren().add(txtEmployeeSearch);
        employeesAnchor.getChildren().add(btnEmployeesSearch);
        employeesAnchor.getChildren().add(buttonBar1);
        employeesAnchor.getChildren().add(btnEmployeeAdd);
        employeesAnchor.getChildren().add(btnEmployeeModify);
        employeesAnchor.getChildren().add(btnEmployeeDelete);
        getChildren().add(label);
        getChildren().add(btnLogout);
        if(userLevel==1){
            getChildren().add(productsAnchor);
            getChildren().add(employeesAnchor);
        }
        else if (userLevel==2){
            getChildren().add(productsAnchor);
        }
        getChildren().add(transactionsAnchor);

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

    protected abstract void handleEmployeeSearch(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeAdd(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeModify(javafx.event.ActionEvent actionEvent);

    protected abstract void handleEmployeeDelete(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLogout(javafx.event.ActionEvent actionEvent);

}
