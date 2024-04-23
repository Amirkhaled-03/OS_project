
package SJF;

import java.util.ArrayList;
import SJF.utils.Pathes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Pathes.VIEWS + "addProcessView.fxml"));
        primaryStage.setTitle("SJF Algorithm");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // ArrayList<Process> processes = new ArrayList<>();
        launch(args);
    }
}
