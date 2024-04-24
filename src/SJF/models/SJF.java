package SJF.models;

import java.util.ArrayList;

public class SJF {

    private static ArrayList<Process> processes = new ArrayList<>();

    public static void addProcess(Process process) {
        processes.add(process);
    }

    public static ArrayList<Process> getProcesses() {
        return processes;
    }
}