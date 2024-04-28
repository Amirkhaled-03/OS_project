package SJF.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import SJF.utils.*;
import SJF.models.*;
import SJF.models.Process;

public class AddProcessController {

    private int numberOfProcesses;
    @FXML
    Label processName;
    @FXML
    TextField arrivalTime;
    @FXML
    Label tableHeader;
    @FXML
    TextField burstTime;
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button add;
    @FXML
    Label arrivalTimeErrorInput;
    @FXML
    Label burstTimeErrorInput;
    int count = 1;
    VBox content = new VBox();
    TextField textField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void add(ActionEvent event) throws IOException {

        scrollPane.setContent(content);
        String AT = arrivalTime.getText();
        String BT = burstTime.getText();
        tableHeader.setText(" PName    Arrival-time    Burst-Time");
        arrivalTimeErrorInput.setText("");
        burstTimeErrorInput.setText("");

        processName.setText("Process" + (count + 1) + " info:");
        validateInput(AT, BT);

        if (count == numberOfProcesses - 1) {
            add.setText("Next");
        }
        if (count == numberOfProcesses) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Pathes.GO_BACK + Pathes.VIEWS + "ProcessDetails.fxml"));
            root = loader.load();
            ProcessDetailsController processDetailsController = loader.getController();
            Process.execute();
            processDetailsController.setList(SJF.getProcesses());
            processDetailsController.setAvrageWaitingTime(Process.getAvgTotalWaitingTime());
            processDetailsController.setAvrageTurnAroundTime(Process.getAvgTotalTurnaroundTime());
            processDetailsController.setAvrageResponseTime(Process.getAvgTotalResponseTime());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    public void reset(ActionEvent event) throws IOException {
        arrivalTime.clear();
        burstTime.clear();
    }

    private void validateInput(String AT, String BT) {
        // Functions f = new Functions();

        if (Functions.isValidPositiveInt(AT) && Functions.isValidPositiveInt(BT)) {
            Process process = new Process(Functions.castInt(AT), Functions.castInt(BT));
            SJF.addProcess(process);
            content.getChildren().add(new Label(process.toString()));
            arrivalTime.clear();
            burstTime.clear();
            count++;
        } else {
            if (!Functions.isValidPositiveInt(AT))
                arrivalTimeErrorInput.setText("Arrival time must be +ve int");
            if (!Functions.isValidPositiveInt(BT))
                burstTimeErrorInput.setText("Burst time must be +ve int");
        }
    }

    public int getNumberOfProcesses() {
        return numberOfProcesses;
    }

    public void setNumberOfProcesses(int numberOfProcesses) {
        this.numberOfProcesses = numberOfProcesses + 1;
    }

    /**
     * 
     * ---- how ca we add multiple nodes in scrollpane?
     * To add content to a ScrollPane programmatically, you would typically set the
     * content of the ScrollPane
     * using its setContent() method. However, the setContent() method in JavaFX's
     * ScrollPane expects a single node as its parameter,
     * not a list of nodes.
     * If you want to add multiple nodes to a ScrollPane, you can wrap them in a
     * layout container
     * (e.g., VBox, HBox, GridPane) and then set that container as the content of
     * the ScrollPane.
     * 
     */
}