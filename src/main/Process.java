package main;

public class Process implements Comparable<Process> {

    private String identificator;
    private int duration;
    private int startTime;
    private int completeTime;

    

    public Process(String identificator, int duration) {
        this.identificator = identificator;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(int completeTime) {
        this.completeTime = completeTime;
    }

    public String getIdentificator(){
        return identificator;
    }

    @Override
    public int compareTo(Process otherProcess) {
        if(this.duration < otherProcess.duration){
            return -1;
        }
        if (this.duration > otherProcess.duration){
            return 1;
        }
        return 0;    
    }

}
