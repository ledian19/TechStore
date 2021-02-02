package TechStore.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User implements Serializable {

    public static ObservableList<User> allUsers = FXCollections.observableArrayList();

    private String username;
    private String password;
    private String fullName;
    private Double salary;
    private String phoneNo;
    private String email;
    private Date birthday;
    private Integer userLevel; //1=Admin (admin, admin), 2=Manager (manager, manager), 3=Employee(employee, employee)

    //Constructor
    public User() {
        
    }

    public static String isUserValid(User u, Boolean isModifyMode){
        if (isModifyMode){
            if (UsernameTaken(u.getUsername())){
                return "Entered username is taken";
            }
        }
        else if (userExists(u.getUsername())){
            return "User exists";
        }
        if (u.getBirthday() == null | u.getUserLevel()==null | u.getEmail()==null | 
                u.getFullname()==null | u.getPassword()==null | u.getPhone()==null | 
                u.getSalary()==null | u.getUsername()==null){
            return "Fill in all values";
        }
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(u.getEmail());

        if (!matcher.matches()){
            return "Invalid email!";
        }
        return "";
    }
    
    private static Boolean userExists(String username){
        for(int i=0; i<allUsers.size(); i++){
            if (username.equals(allUsers.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }
    
    private static Boolean UsernameTaken(String username){
        int count=0;
        for(int i=0; i<allUsers.size(); i++){
            if (username.equals(allUsers.get(i).getUsername())){
                count++;
            }
        }
        if (count>1){
            return true;
        }
        return false;
    }
    
    public void setFullname(String f) {
        this.fullName = f;
    }

    public String getFullname() {
        return this.fullName;
    }

    public void setSalary(Double s) {
        this.salary = s;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setPhone(String p) {
        this.phoneNo = p;
    }

    public String getPhone() {
        return this.phoneNo;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getEmail() {
        return this.email;
    }

    public void setBirthday(Date b) {
        this.birthday = b;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserLevel() {
        return this.userLevel;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public static void addUser(User u){
        allUsers.add(u);
    }
    
    public static void updateUser(int index, User u){
        allUsers.set(index, u);
    }
    
    public static void deleteUser(User u){
        allUsers.remove(u);
    }
    
    public static int lookupUser(String searchTerm){
        boolean isFound = false;
        int index = 0;
        for (int i = 0; i < allUsers.size(); i++) {
            if (searchTerm.equalsIgnoreCase(allUsers.get(i).getUsername())) {
                index = i;
                isFound = true;
            }
        }
        if (isFound == true) {
            System.out.println("User found");
            return index;
            
        } else {
            System.out.println("No user found.");
            return -1;
        }
       
    }
}
