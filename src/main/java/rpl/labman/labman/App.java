package rpl.labman.labman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Connection conn;
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labman", "root", "");
            System.out.println("Connected With the database successfully");
        } catch (SQLException e){
            System.out.println("Error while connecting to the database \n"+e.getMessage());
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
        Parent root = loader.load();
        //Parent root=FXMLLoader.load(getClass().getResource("homePage.fxml"));
        HomePageController controller = loader.getController();
        controller.setDBConnection(conn);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");        
        stage.setScene(scene);
        stage.show();
        
    }
  
    public static void main(String[] args) {
        launch(args);
    }
    
    public void stop() throws Exception {
        // Menutup koneksi database saat aplikasi ditutup
        if (conn != null) {
            conn.close();
            System.out.println("Disconnected from the database");
        }
    }
}