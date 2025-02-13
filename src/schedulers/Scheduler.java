package schedulers;
import java.util.ArrayList;

import main.Core;
import main.Process;

public abstract class Scheduler {
    
    ArrayList<Process> readyProcesses = new ArrayList<>();
    ArrayList<Core> availableCores = new ArrayList<>();

    public void addReadyProcess(Process process){
        readyProcesses.add(process);
        scheduleProcess();
    }

    private Core getLeastLoadedCore(){
        Core leastLoadedCore = availableCores.get(0);
        for (Core core : availableCores) {
            if(core.getEstimatedTimeWorking() < leastLoadedCore.getEstimatedTimeWorking()){
                leastLoadedCore = core;
            }
        }
        return leastLoadedCore;
    }
    
    public Process extractFirstProcess(){
        if(!readyProcesses.isEmpty()) {
            return readyProcesses.remove(0);
        } else {
            return null;
        }
    }

    public Process getFirstProcess(){
        return readyProcesses.get(0);
    }

    public void assignTasks(){
        while(!readyProcesses.isEmpty()) {
            getLeastLoadedCore().addProcessToExecute(extractFirstProcess());
        }
    }

    public void printTasksAssigned(){
        System.out.println();
        for (Core core : availableCores) {
            System.out.println("Core #" + core.getCoreID());
            for (Process process : core.getProcessToExecute()) {
                System.out.println(process.getIdentificator() + ";" + process.getStartTime() + ";" + process.getCompleteTime());
            }
            System.out.println();
        }
    }

    public abstract void scheduleProcess();
}