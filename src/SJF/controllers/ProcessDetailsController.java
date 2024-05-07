package SJF.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import SJF.models.Process;
import SJF.utils.Constants;
import SJF.utils.Pathes;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProcessDetailsController implements Initializable {

    @FXML
    private TableView<Process> processDetails;
    @FXML
    private TableColumn<Process, Integer> processID;
    @FXML
    private TableColumn<Process, Integer> arrivalTime;
    @FXML
    private TableColumn<Process, Integer> burstTime;
    @FXML
    private TableColumn<Process, Integer> waitingTime;
    @FXML
    private TableColumn<Process, Integer> turnAroundTime;
    @FXML
    private TableColumn<Process, Integer> responseTime;
    @FXML
    private Label avrageWaitingTime;
    @FXML
    private Label avrageTurnAroundTime;
    @FXML
    private Label avrageResponseTime;
    private ObservableList<Process> list;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane scenePane4;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Chart chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        processID.setCellValueFactory(new PropertyValueFactory<Process, Integer>("processNumber"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<Process, Integer>("arrivalTime"));
        burstTime.setCellValueFactory(new PropertyValueFactory<Process, Integer>("burstTime"));
        waitingTime.setCellValueFactory(new PropertyValueFactory<Process, Integer>("waitingTime"));
        turnAroundTime.setCellValueFactory(new PropertyValueFactory<Process, Integer>("turnaroundTime"));
        responseTime.setCellValueFactory(new PropertyValueFactory<Process, Integer>("responseTime"));

    }

    public void setList(ArrayList<Process> list) {
        this.list = FXCollections.observableArrayList(list);
        processDetails.setItems(this.list);

    }

    public void setAvrageWaitingTime(double avrageWaitingTime) {
        this.avrageWaitingTime.setText("Avrage Waiting Time: " + avrageWaitingTime);
    }

    public void setAvrageTurnAroundTime(double avrageTurnAroundTime) {
        this.avrageTurnAroundTime.setText("Avrage Turn Around Time: " + avrageTurnAroundTime);
    }

    public void setAvrageResponseTime(double avrageResponseTime) {
        this.avrageResponseTime.setText("Avrage Response Time: " + avrageResponseTime);
    }

    public void exit4(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit?");
        if (alert.showAndWait().get() != ButtonType.OK)
            return;
        Stage stage = (Stage) scenePane4.getScene().getWindow();
        stage.close();
    }

    public void showGanttChart(ActionEvent event) {
        Stage stage2 = new Stage();
        GantAlgorithm gantAlgorithm = new GantAlgorithm();
        chart = gantAlgorithm.start1();
        scene = new Scene(chart, Constants.WIDTH, Constants.HEIGHT);
        InputStream iconStream = getClass().getResourceAsStream(Pathes.GO_BACK + Pathes.IMAGES + "icon.jpeg");
        if (iconStream != null) {
            Image icoImage = new Image(iconStream);
            stage2.getIcons().add(icoImage);
        } else
            System.out.println("Failed to load icon image.");
        stage2.setScene(scene);
        stage2.show();
    }
}
