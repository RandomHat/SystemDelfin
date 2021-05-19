package model;

import java.util.Date;

public abstract class Result{
    private int time;
    private Date date;

    public Result(int time, Date date){
        this.time = time;
        this.date = date;
    }

    //public abstract int compareResults(TournamentResult o, TrainingResult j);

    public int getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
}
