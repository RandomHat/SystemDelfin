package model;

import java.util.Date;

public abstract class Result{
    private int time;
    private Date date;
    private SwimDiscipline discipline;

    public Result(int time, Date date, SwimDiscipline discipline){
        this.time = time;
        this.date = date;
        this.discipline = discipline;
    }

    //public abstract int compareResults(TournamentResult o, TrainingResult j);

    public int getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
    public SwimDiscipline getDiscipline(){
        return discipline;
    }
}
