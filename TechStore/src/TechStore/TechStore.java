package TechStore;

import TechStore.Controller.LoginViewController;
import TechStore.Controller.MainPageController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TechStore extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        LoginViewController root = new LoginViewController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("TechStore Management System");
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
}
