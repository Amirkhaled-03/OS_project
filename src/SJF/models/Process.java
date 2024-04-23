package SJF.models;

public class Process {

    static private int processCount = 0;
    static private int totalWaitingTime;
    static private int totalTurnaroundTime;
    static private int totalResponseTime;

    private String ProcessName;
    private int arrivalTime;
    private int burstTime;
    private int remainingBurstTime;
    private int waitingTime;
    private int turnaroundTime;
    private int responseTime;

    private boolean firstTime = true;
    private boolean hasExecuted;

    public Process() {

    }

    public Process(int arrivalTime, int burstTime) {
        ProcessName = "P" + ++processCount;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

        this.remainingBurstTime = burstTime;
        this.responseTime = -1;
        hasExecuted = false;
        firstTime = true;
    }

    public void execute(int currentTime) {
        this.remainingBurstTime--;
        if (responseTime == -1) {
            this.responseTime = currentTime - arrivalTime;
        }
        if (remainingBurstTime == 0) {
            hasExecuted = true;
            turnaroundTime = currentTime - arrivalTime + 1;
            calcWatingTime();
            Process.totalWaitingTime += waitingTime;
            Process.totalResponseTime += responseTime;
            Process.totalTurnaroundTime += turnaroundTime;
        }
    }

    public int calcWatingTime() {

        waitingTime = (turnaroundTime - burstTime);
        return waitingTime;

    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public String getProcessName() {
        return ProcessName;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public static int gettotalWaitingTime() {
        return totalWaitingTime;
    }

    public static int gettotalResponseTime() {
        return totalResponseTime;
    }

    public static int gettotalTurnaroundTime() {
        return totalTurnaroundTime;
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

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public boolean getFirstTime() {
        return firstTime;
    }

    public void setHasExecuted(boolean hasExecuted) {
        this.hasExecuted = hasExecuted;
    }

    public boolean getHasExecuted() {
        return this.hasExecuted;
    }

    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }

    public void setRemainingBurstTime(int remainingBurstTime) {
        this.remainingBurstTime = remainingBurstTime;
    }

    public static void setTotalResponseTime(int totalResponseTime) {
        Process.totalResponseTime = totalResponseTime;
    }

    public static void setTotalTurnaroundTime(int totalTurnaroundTime) {
        Process.totalTurnaroundTime = totalTurnaroundTime;
    }

    public static void setTotalWaitingTime(int totalWaitingTime) {
        Process.totalWaitingTime = totalWaitingTime;
    }

    public static int getTotalResponseTime() {
        return totalResponseTime;
    }

    public static int getTotalTurnaroundTime() {
        return totalTurnaroundTime;
    }

    public static int getTotalWaitingTime() {
        return totalWaitingTime;
    }

    @Override
    public String toString() {

        return " " + ProcessName + "           " + arrivalTime + "                        " + burstTime;
    }
}
