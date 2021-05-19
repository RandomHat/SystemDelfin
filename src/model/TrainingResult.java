package model;

import java.util.Date;

public class TrainingResult extends Result implements Comparable<TrainingResult>{

    public TrainingResult(int time, Date date) {
        super(time, date);
    }


    @Override
    public int compareTo(TrainingResult o) {
        if(time > o.time){
            return 1;
        }else if(time < o.time){
            return -1;
        } else
            return 0;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
