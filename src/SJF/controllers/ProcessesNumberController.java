package SJF.controllers;

import SJF.utils.Pathes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProcessesNumberController {
    @FXML
    private Button nextButton;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField InputNumberOfProcesses;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane scenePane1;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void submit(ActionEvent event) {

        try {
            int numberOfProcesses = Integer.parseInt(InputNumberOfProcesses.getText());
            if (numberOfProcesses <= 0) {
                this.errorMessage.setText("Please enter a number greater than 0");

            } else {
                this.errorMessage.setText("");

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(Pathes.GO_BACK + Pathes.VIEWS + "addProcessView.fxml"));
                root = loader.load();
                AddProcessController addProcessController = loader.getController();
                addProcessController.setNumberOfProcesses(numberOfProcesses);
                if (numberOfProcesses == 1) { // if the there is only one process will enter, set the text, we make it
                                              // here bex it must set before the UI build
                    addProcessController.setButtonText("Next");

                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root, 897.0, 615.0);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            this.errorMessage.setText("Please enter a number greater than 0");
            System.out.println(e);
        }
    }

    public void exit1(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit?");
        if (alert.showAndWait().get() != ButtonType.OK)
            return;
        Stage stage = (Stage) scenePane1.getScene().getWindow();
        stage.close();
    }
}
