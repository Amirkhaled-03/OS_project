package SJF.models;

import java.util.ArrayList;

public class Process {
    static private int processCount = 0;
    static private int totalWaitingTime = 0;
    static private int totalTurnaroundTime = 0;
    static private int totalResponseTime = 0;
    static private int totalBurstTime = 0;

    static private double avgTotalWaitingTime;
    static private double avgTotalTurnaroundTime;
    static private double avgTotalResponseTime;
    static private double avgTotalBurstTime = 0;

    static private ArrayList<Integer> stopTimes = new ArrayList<>();
    static private ArrayList<Integer> proccProgress = new ArrayList<>();

    private int processNumber;
    private int arrivalTime;
    private int burstTime;
    private int remainingBurstTime;
    private int waitingTime;
    private int turnaroundTime;
    private int responseTime;
    private int finishTime;
    private boolean isFirstTime;
    private boolean isFinished;

    public Process(int arrivalTime, int burstTime) {
        processNumber = ++processCount;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

        this.remainingBurstTime = burstTime;
        this.totalBurstTime += burstTime;
        this.isFirstTime = true;
        this.isFinished = false;
    }

    public static int getLoopsCount() {
        int loopCount;
        loopCount = SJF.getProcesses().get(SJF.getProcesses().size() - 1).getArrivalTime() + totalBurstTime;
        return loopCount;
    }

    public static void execute() {
        bubbleSortArrival(SJF.getProcesses());
        int proccNum = 0;
        int prevProccNum = 0;
        Process currentProcess;

        for (int i = 0; i <= getLoopsCount(); i++) {

            proccNum = SJF.lowestRemainingBurstTime(i);

            if (proccNum == 0) {
                if (proccNum != prevProccNum) {
                    stopTimes.add(i);
                    proccProgress.add(0);
                    prevProccNum = proccNum;
                }
                continue;
            }

            currentProcess = SJF.getProcess(proccNum);

            if (proccNum != prevProccNum) { // adding stops to the  list
                stopTimes.add(i);
                proccProgress.add(currentProcess.getProccesNumber());
                prevProccNum = proccNum;
            }

            if (currentProcess.isFirstTime) { // Response time calc
                currentProcess.isFirstTime = false;
                currentProcess.responseTime = i - currentProcess.arrivalTime;
            }

            currentProcess.decrementBurstTime();
            // System.out.println(proccNum + "," + currentProcess.getRemainingBurstTime());
        }
        for (Process p : SJF.getProcesses()) {
            totalResponseTime += p.responseTime;
            totalTurnaroundTime += p.turnaroundTime;
            totalWaitingTime += p.waitingTime;
        }

        // System.out.println("Turn= " + totalTurnaroundTime);
        // System.out.println("wait= " + totalWaitingTime);
        // System.out.println("resp= " + totalResponseTime);
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }

    public int getProccesNumber() {
        return processNumber;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void decrementBurstTime() {
        this.remainingBurstTime--;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public static int getTotalBurstTime() {
        return totalBurstTime;
    }

    public static int getProcessCount() {
        return processCount;
    }

    public static int getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public static int getTotalTurnaroundTime() {
        return totalTurnaroundTime;
    }

    public static int getTotalResponseTime() {
        return totalResponseTime;
    }

    public static ArrayList<Integer> getStopTimes() {
        return stopTimes;
    }

    public static ArrayList<Integer> getProccProgress() {
        return proccProgress;
    }

    public static void resetProcessCount(){
        processCount = 0;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    

    public int getFinishTime() {
        return finishTime;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }

    public static void setAvgTotalBurstTime(double avgTotalBurstTime) {
        Process.avgTotalBurstTime = avgTotalBurstTime;
    }

    public static void setAvgTotalResponseTime(double avgTotalResponseTime) {
        Process.avgTotalResponseTime = avgTotalResponseTime;
    }

    public static void setAvgTotalTurnaroundTime(double avgTotalTurnaroundTime) {
        Process.avgTotalTurnaroundTime = avgTotalTurnaroundTime;
    }

    public static void setAvgTotalWaitingTime(double avgTotalWaitingTime) {
        Process.avgTotalWaitingTime = avgTotalWaitingTime;
    }

    public static double getAvgTotalBurstTime() {
        return (double) totalBurstTime / processCount;
    }

    public static double getAvgTotalResponseTime() {
        return (double) totalResponseTime / processCount;
    }

    public static double getAvgTotalTurnaroundTime() {
        return (double) totalTurnaroundTime / processCount;
    }

    public static double getAvgTotalWaitingTime() {
        return (double) totalWaitingTime / processCount;
    }



    private static void bubbleSortArrival(ArrayList<Process> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j).getArrivalTime() > arr.get(j + 1).getArrivalTime()) {
                    Process temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public String toString() {

        return " " + processNumber + "           " + arrivalTime + "                        " + burstTime;
    }

}
