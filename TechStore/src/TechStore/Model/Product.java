package TechStore.Model;

import java.io.Serializable;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product implements Serializable{
    
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    private String name;
    private String category;
    private String username;
    private Date dateAdded;
    private Double price;
    private int quantity;
    
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
   
   public void setPrice(double price){
       this.price = price;
   }
   
   public double getPrice(){
       return this.price;
   }
   
   public void setQuantity(int q){
       this.quantity = q;
   }
   
   public int getQuantity(){
       return this.quantity;
   }
   
   public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
    public static void addProduct(Product p){
        allProducts.add(p);
    }
    
    public static void deleteProduct(Product p){
        allProducts.remove(p);
    }
    
    public static void updateProduct(int index, Product p){
        allProducts.set(index, p);
    }
    
   public static Boolean productExists(String pName){
       for(int i=0; i<allProducts.size(); i++){
           if(pName.equals(allProducts.get(i).getName())){
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
   
    public static int lookupProduct(String searchTerm){
        boolean isFound = false;
        int index = 0;
        for (int i = 0; i < allProducts.size(); i++) {
            if (searchTerm.equalsIgnoreCase(allProducts.get(i).getName())) {
                index = i;
                isFound = true;
            }
        }
        if (isFound == true) {
            System.out.println("Product found");
            return index;
            
        } else {
            System.out.println("No product found.");
            return -1;
        }
       
    }
    
}
