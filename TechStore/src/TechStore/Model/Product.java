package TechStore.Model;

import static TechStore.Model.Bill.allBills;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
    
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    private String name;
    private String category;
    private String username;
    private Date dateAdded;
    private Double price;
    private int inStock;
    
    public Product() {
        name = new String();
    }
   
    public void setName(String name){
       this.name = name;
   }
   
   public String getName(){
       return this.name;
   }
   
    public void setUsername(String u){
       this.username = u;
   }
   
   public String getUsername(){
       return this.username;
   }
   
    public void setDate(Date d){
        this.dateAdded = d;
    }
    
    public Date getDate(){
        return this.dateAdded;
    }
    
    public void setCategory(String cat){
       this.category = cat;
   }
   
   public String getCategory(){
       return this.category;
   }
   
   //Price
   public void setPrice(double price){
       this.price = price;
   }
   
   public double getPrice(){
       return this.price;
   }
   
   //inStock
   public void setInStock(int stock){
       this.inStock = stock;
   }
   
   public int getInStock(){
       return this.inStock;
   }
   
   public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
    public static Boolean addBill(Product p){
        if(productExists(p)){
            return false;
        }
        allProducts.add(p);
        return true;
    }
    
    //
    public static void deleteBill(Product p){
        allProducts.remove(p);
    }
    
    public static void updateBill(int index, Product p){
        allProducts.set(index, p);
    }
    
   public static Boolean productExists(Product product){
       for(int i=0; i<allProducts.size(); i++){
           if(product.getName().equals(allProducts.get(i).getName())){
               return true;
           }
       }
       return false;
   }
   
   public static String isProductValid (String name, double price, int quantity, String category) {
       String errorMessage = "";
       if (name == null) {
           errorMessage = errorMessage + "The name field is required. ";
       }
       if (category == null) {
           errorMessage = errorMessage + "The category field is required. ";
       }
       if (price <= 0) {
           errorMessage = errorMessage + "The price must be greater than 0.";
       }
       if (quantity <= 0) {
           errorMessage = errorMessage + "The quantity must be greater than 0.";
       }
       return errorMessage; 
   }
}
