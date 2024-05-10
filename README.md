# Shortest Job First (Preemptive) Simulation

## Overview
This project is a simulation of the Shortest Job First (Preemptive) scheduling algorithm using JavaFX. It allows users to input process data, visualize the scheduling using a Gantt Chart, and calculate various metrics such as waiting time, turnaround time, and response time.

## Installation
1. Clone this repository to your local machine.
2. Ensure you have JavaFX installed.
3. Compile the Java files.
4. Run the main JavaFX application file.

## Usage
1. Launch the application.
2. Enter the number of processes.
3. Input the arrival time, burst time, and priority (if applicable) for each process.
4. Click "Next" to start the scheduling.
5. View the Gantt Chart and metrics displayed.

## Features
- User-defined number of processes.
- User-defined process data (arrival time, burst time, priority).
- Graphical User Interface (GUI) with Gantt Chart visualization.
- Validation for input data (no negative numbers or characters allowed).
- Calculation of waiting time, turnaround time, and response time for each process.
- Calculation of average waiting time, average turnaround time, and average response time.

## How it Works
The Shortest Job First (Preemptive) algorithm selects the process with the shortest burst time to execute next. If a new process arrives with a shorter burst time, it preempts the currently running process and starts executing the new process.

## video
![video ](demo.mp4)



