
package SJF;

import SJF.utils.Pathes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Pathes.VIEWS + "ProcessesNumber.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("SJF Algorithm");
        // // image
        // Image icoImage = new Image(Pathes.VIEWS + "logo.jpeg");
        // primaryStage.setScene(scene);

        // // icon
        // primaryStage.getIcons().add(icoImage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // ArrayList<Process> processes = new ArrayList<>();
        launch(args);
    }
}
