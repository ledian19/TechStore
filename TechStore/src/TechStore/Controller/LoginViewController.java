package TechStore.Controller;

import TechStore.Model.User;
import static TechStore.Model.User.allUsers;
import TechStore.Views.LoginView;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginViewController extends LoginView implements Initializable {

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

    public static void readAllUsersFromFile() {
        try {
            File uf = new File("src/resources/users.ser");
            FileInputStream file = new FileInputStream(uf);
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream input = new ObjectInputStream(buffer);
            
            ArrayList<User> list = (ArrayList<User>) input.readObject();
            allUsers = FXCollections.observableList(list);
            file.close();
            buffer.close();
            input.close();
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static void writeUsersToFile() {
        try {            
            File f = new File("src/resources/users.ser");
            FileOutputStream fl = new FileOutputStream(f);
            BufferedOutputStream bf = new BufferedOutputStream(fl);
            ObjectOutput output = new ObjectOutputStream(bf);
            output.writeObject(new ArrayList<>(allUsers));
            bf.close();
            fl.close();
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

    public ObservableList<User> getAllUsers() {
        return allUsers;
    }

    public void addUser(User user) {
        allUsers.add(user);
    }

    public void deleteUser(User user) {
        allUsers.remove(user);
    }

    public void updateUser(int index, User user) {
        allUsers.set(index, user);
    }

}
