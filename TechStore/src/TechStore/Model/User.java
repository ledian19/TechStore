package TechStore.Model;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private Integer userLevel; //1=Admin (admin, admin), 2=Manager (manager, manager), 3=Employee(employee, employee)

    //Constructor
    public User(String uname, String pwd, Integer uLevel) {
        this.username = uname;
        this.password = pwd;
        this.userLevel = uLevel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getUserLevel() {
        return this.userLevel;
    }
}
