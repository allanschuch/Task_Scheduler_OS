package main;

import java.util.ArrayList;

public class Core {

    ArrayList<Process> processToExecute = new ArrayList<>();
    private int estimatedTimeWorking = 0;
    private int coreID;

    // Adds the number of the core to its identification

    public Core(int idProcessor) {
        this.coreID = idProcessor;
    }

    public int getCoreID() {
        return coreID;
    }

    public ArrayList<Process> getProcessToExecute() {
        return processToExecute;
    }

    public void addProcessToExecute(Process process) {
        process.setStartTime(estimatedTimeWorking);
        process.setCompleteTime(estimatedTimeWorking + process.getDuration());
        processToExecute.add(process);
        System.out.println("Process (" + process.getIdentificator() + ") added to the core: Core #" + this.coreID );
        estimatedTimeWorking += process.getDuration();
    }

    public int getEstimatedTimeWorking() {
        return estimatedTimeWorking;
    }
    public void setEstimatedTimeWorking(int estimatedTimeWorking) {
        this.estimatedTimeWorking = estimatedTimeWorking;
    }

    
}