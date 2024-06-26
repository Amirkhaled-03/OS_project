package SJF.models;

import java.util.ArrayList;

import SJF.controllers.ProcessDetailsController;

public class SJF {

    private static ArrayList<Process> processes = new ArrayList<>();

    public static void addProcess(Process process) {
        processes.add(process);
    }

    public static ArrayList<Process> getProcesses() {
        return processes;
    }




    public static Process getProcess(int pNum) {
        for(Process p: processes){
            if(p.getProccesNumber() == pNum)
                return p;
        }
        return new Process(0,0);
    }

    public static int getMaxRemainingBurstTime() {
        int max = 0;
        for (Process p : processes) {
            if (p.getRemainingBurstTime() > max)
                max = p.getRemainingBurstTime();
        }
        return max;
    }

    public static int lowestRemainingBurstTime(int currentTime) {
        int min = SJF.getMaxRemainingBurstTime() + 1;
        int pNum = 0;
        Process process;
        for (int i = 0; i < processes.size(); i++) {
            process = processes.get(i);
            if (process.getArrivalTime() > currentTime)
                continue;
            if (process.getRemainingBurstTime() < min && process.getRemainingBurstTime() != 0) {

                min = process.getRemainingBurstTime();
                pNum = process.getProccesNumber();
            }
            if (!process.getIsFinished() && process.getRemainingBurstTime() == 0) {
                process.setIsFinished(true);
                process.setFinishTime(currentTime);
                process.setTurnaroundTime(currentTime - process.getArrivalTime()); 
                process.setWaitingTime((currentTime - process.getArrivalTime()) - process.getBurstTime());
                                                                                                           
                                                                                                           
            }

        }
        return pNum;
    }
}
