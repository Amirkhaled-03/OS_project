package SJF.models;

import java.util.ArrayList;

public class SJF {

    private ArrayList<Process> processes = new ArrayList<>();

    public void addProcess(Process process) {
        processes.add(process);
    }

    public ArrayList<Process> getProcesses() {
        return processes;
    }
}