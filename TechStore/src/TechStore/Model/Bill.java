package TechStore.Model;

import java.io.Serializable;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bill implements Serializable {

    public static ObservableList<Bill> allBills = FXCollections.observableArrayList();

    private String name;
    private Double price;
    private Integer quantity;
    private Double total;
    private String username;
    private Date dateAdded;
    
    public Bill() {
        name = new String();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setDate(Date d){
        this.dateAdded = d;
    }
    
    public Date getDate(){
        return this.dateAdded;
    }
    
    public void setUsername(String u){
        this.username = u;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public void setQuantity(int q){
        this.quantity = q;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public static ObservableList<Bill> getAllBills () {
        return allBills;
    }

    public static void addBill(Bill bill){
        allBills.add(bill);
    }
    
    public static void deleteBill(Bill bill){
        allBills.remove(bill);
    }
    
    public static void updateBill(int index, Bill bill){
        allBills.set(index, bill);
    }
    
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static String isBillValid (String name, double price, int quantity) {
       String errorMessage = "";
       if (name == null) {
           errorMessage = errorMessage + "The name field is required. ";
       }
       if (price <= 0) {
           errorMessage = errorMessage + "The price must be greater than 0. ";
       }
       if (quantity <= 0) {
           errorMessage = errorMessage + "The price must be greater than 0. ";
       }
       return errorMessage; 
   }
   
    public static int lookupTransaction(String searchTerm){
        boolean isFound = false;
        int index = 0;
        for (int i = 0; i < allBills.size(); i++) {
            if (searchTerm.equalsIgnoreCase(allBills.get(i).getName())) {
                index = i;
                isFound = true;
            }
        }
        if (isFound == true) {
            System.out.println("Bill found");
            return index;
            
        } else {
            System.out.println("No bills found.");
            return -1;
        }
       
    }
    
}
