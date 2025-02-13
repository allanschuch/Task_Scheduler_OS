package schedulers;
import java.util.ArrayList;
import java.util.Collections;
import main.Process;
import main.Core;

public class ShortestJobFirst extends Scheduler{

    public ShortestJobFirst(ArrayList<Core> cores){
        super.availableCores = cores;
    }
    
    public ShortestJobFirst(ArrayList<Core> cores, ArrayList<Process> processes){
        super.readyProcesses = processes;
        super.availableCores = cores;
    }

    @Override
    public void scheduleProcess(){
        Collections.sort(super.readyProcesses);
    }

}