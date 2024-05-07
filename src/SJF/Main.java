
package SJF;

import java.io.InputStream;

import SJF.utils.Constants;
import SJF.utils.Pathes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(Pathes.VIEWS + "ProcessesNumber.fxml"));
        Scene scene = new Scene(root, Constants.WIDTH, Constants.HEIGHT);

        primaryStage.setTitle("SJF Algorithm");

        InputStream iconStream = getClass().getResourceAsStream(Pathes.IMAGES + "icon.jpeg");
        if (iconStream != null) {
            Image icoImage = new Image(iconStream);
            primaryStage.getIcons().add(icoImage);
        } else
            System.out.println("Failed to load icon image.");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
