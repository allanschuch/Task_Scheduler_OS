package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import schedulers.Scheduler;
import schedulers.ShortestJobFirst;

public class TaskScheduler {
    public static void main(String[] args){
        
        int coresAvailable = Integer.parseInt(args[1]);
        String processId;
        String processDuration;
        String line;
        ArrayList<Core> cores = new ArrayList<>();

        for(int k = 0; k < coresAvailable; k++){
            Core core = new Core(k);
            cores.add(core);
        }

        Scheduler scheduler = null;

        switch(args[2]){
            case "1":{
                scheduler = new ShortestJobFirst(cores);
                System.out.println("Scheduler: SHORTEST JOB FIRST\n");
                break;
            }
            default:{
                System.out.println("Invalid scheduling policy. Check if the third argument match with one of these:\n1- Shortest Job First\n");
                System.exit(-1);
            }
        }
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            while(reader.ready()){
                line = reader.readLine();
                processId = line.substring(0, line.indexOf(" "));
                processDuration = line.substring(line.indexOf(" "), line.length()).strip();
                Process process = new Process(processId, Integer.parseInt(processDuration));
                scheduler.addReadyProcess(process);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        scheduler.assignTasks();
        scheduler.printTasksAssigned();
    }
}
