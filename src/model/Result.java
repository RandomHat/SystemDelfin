package model;

import java.util.Date;

public abstract class Result{
    private double time;
    private Date date;

    public Result(double time, Date date){
        this.time = time;
        this.date = date;
    }

    //public abstract int compareResults(TournamentResult o, TrainingResult j);

    public double getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
}
