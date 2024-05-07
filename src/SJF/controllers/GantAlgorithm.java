package SJF.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import SJF.models.GanttChart;
import SJF.models.GanttChart.ExtraData;
import SJF.utils.Pathes;
import SJF.models.SJF;
import SJF.models.Process;

// TODO: use date for x-axis
public class GantAlgorithm {

    public Chart start1() {

        // stage.setTitle("Gantt Chart Sample");

        int processCount = SJF.getProcesses().size();

        String[] machines = new String[processCount];
        for (int i = 0; i < processCount; i++) {
            machines[i] = "Process" + (i + 1);
        }

        String machine;

        ArrayList<XYChart.Series> series = new ArrayList<>();

        for (int i = 0; i < Process.getStopTimes().size() - 1; i++) {
            XYChart.Series series1 = new XYChart.Series();
            int start, length;
            start = Process.getStopTimes().get(i);
            length = Process.getStopTimes().get(i + 1) - start;

            int machineNum = Process.getProccProgress().get(i) - 1;
            if (machineNum < 0)
                continue;
            machine = machines[machineNum];
            series1.getData().add(new XYChart.Data(start, machine, new ExtraData(length, "status-red")));
            series.add(series1);
        }

        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();

        final GanttChart<Number, String> chart = new GanttChart<Number, String>(xAxis, yAxis);
        xAxis.setLabel("TimeLine");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setMinorTickCount(5); // ticks between each time stamp in x axis

        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10); // gap in between tasks y axis
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(machines)));

        chart.setTitle("Shortest Job First Gantt Chart");
        chart.setLegendVisible(false);
        chart.setBlockHeight(25);

        for (XYChart.Series s : series) {
            chart.getData().addAll(s);
        }

        chart.getStylesheets()
                .add(getClass().getResource(Pathes.GO_BACK + Pathes.CSS + "ganttchart.css").toExternalForm());

        return chart;

    }

}
