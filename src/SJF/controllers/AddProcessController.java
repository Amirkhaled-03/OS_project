package SJF.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import SJF.utils.*;
import SJF.models.*;
import SJF.models.Process;


public class AddProcessController {

    private int numberOfProcesses;
    @FXML
    private Label processName;
    @FXML
    private TextField arrivalTime;
    @FXML
    private Label tableHeader;
    @FXML
    private TextField burstTime;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button addButton;
    @FXML
    private Label arrivalTimeErrorInput;
    @FXML
    private Label burstTimeErrorInput;
    private int count = 1;
    private VBox content = new VBox();
    private TextField textField;
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

        validateInputs(AT, BT);

        processName.setText("Process" + (count) + " info:");

        if (count == numberOfProcesses - 1) {
            addButton.setText("Next");
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
            scene = new Scene(root, Constants.WIDTH, Constants.HEIGHT);
            stage.setScene(scene);
            stage.show();

        }

    }

    public void reset(ActionEvent event) throws IOException {
        Process.resetProcessCount();
        SJF.getProcesses().clear();
        content.getChildren().clear();
        arrivalTime.clear();
        burstTime.clear();
        count = 1;
        processName.setText("Process1 info:");
        Label noProcessLabel = new Label("There is no process added");
        noProcessLabel.setFont(Font.font("System Italic", 14.0));
        scrollPane.setContent(noProcessLabel);
    }

    private void validateInputs(String AT, String BT) {

        if (Functions.isValidPositiveInt(AT) && Functions.isValidPositiveInt(BT)) {
            Process process = new Process(Functions.castInt(AT), Functions.castInt(BT));
            SJF.addProcess(process);
            content.getChildren().add(new Label(process.toString()));
            count++;
            arrivalTime.clear();
            burstTime.clear();
        } else {
            if (!Functions.isValidPositiveInt(AT))
                arrivalTimeErrorInput.setText("Enter a valid arrival time");
            if (!Functions.isValidPositiveInt(BT))
                burstTimeErrorInput.setText("Enter a valid burst time");
        }
    }

    public int getNumberOfProcesses() {
        return numberOfProcesses;
    }

    public void setNumberOfProcesses(int numberOfProcesses) {
        this.numberOfProcesses = numberOfProcesses + 1;
    }

    public void setButtonText(String text) {
        this.addButton.setText(text);
        
    }

}