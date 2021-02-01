package TechStore.Controller;

import TechStore.Model.User;
import TechStore.Views.LoginView;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginViewController extends LoginView implements Initializable {

    public ArrayList<User> allUsers = new ArrayList<User>();

    public LoginViewController(){
        readAllUsersFromFile();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    protected Boolean handleLogin(ActionEvent actionEvent) {
        User usr = checkUser(txtUsername.getText(), txtPassword.getText());
        if (usr != null) {
            MainPageController mainParent = new MainPageController(usr);
            Scene mainScene = new Scene(mainParent);
            Stage mainStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();
        }
        lblErrorMessage.setText("Permission denied or user does not exist");
        return false;
    }

    private void readAllUsersFromFile() {
        try {
            File uf = new File("src/resources/users.ser");
            FileInputStream file = new FileInputStream(uf);
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream input = new ObjectInputStream(buffer);
            allUsers = (ArrayList<User>) input.readObject();
            for (User user : allUsers) {
                System.out.println("Data: " + user.getUsername() + "-" + user.getPassword());
            }
            file.close();
            buffer.close();
            input.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Not found. Creating new file"
                    + ex.toString());
            addUser(new User("admin", "admin", 1));
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        }
    }

    //TODO
    public void writeUsersToFile() {
        try {
            User lg = new User("admin", "admin", 1);
            User lg2 = new User("manager", "manager", 2);
            User lg3 = new User("employee", "employee", 3);

            allUsers.add(lg);
            allUsers.add(lg2);
            allUsers.add(lg3);
            
            File uf = new File("src/resources/users.ser");
            FileOutputStream fl = new FileOutputStream(uf);
            BufferedOutputStream bf = new BufferedOutputStream(fl);
            ObjectOutputStream output = new ObjectOutputStream(bf);
            output.writeObject(allUsers);
            fl.close();
            bf.close();
            output.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform output." + ex.toString());
        }
    }

    public User checkUser(String uname, String pwd) {
        for (User User : allUsers) {
            if (uname.equals(User.getUsername()) && pwd.equals(User.getPassword())) {
                return User;
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void addUser(User user) {
        allUsers.add(user);
        writeUsersToFile();
    }

    public void deleteUser(User user) {
        allUsers.remove(user);
    }

    public void updateUser(int index, User user) {
        allUsers.set(index, user);
    }

}
