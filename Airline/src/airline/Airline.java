package airline;

import java.awt.Toolkit;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Airline extends Application {
	

    
	
	 private static final int COUNT_LIMIT = 10;
   @Override
   public void start(Stage stage) throws Exception {	
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       root.getStylesheets().add(getClass().getResource("/resources/style.css").toString());
       stage.getIcons().add(new Image("/images/icon.png"));
       
       stage.initStyle(StageStyle.UNDECORATED);
       Scene scene = new Scene(root);
       
       stage.setScene(scene);
       stage.show();
   }
   @Override
   public void init() throws Exception {       
       
     
       for (int i = 1; i <= COUNT_LIMIT; i++) {
           double progress =(double) i/10;
         
           System.out.println("progress: " +  progress);            
           LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
           Thread.sleep(1300);
           
       }
       
   }

   
   public static void main(String[] args) {
   	LauncherImpl.launchApplication(Airline.class, MyPreloader.class, args);
   }
   
}
