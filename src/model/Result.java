package model;

import java.util.Date;
//@Author Mark Kaplan Hansen
public abstract class Result implements Comparable<Result>{
    private int time;
    private Date date;
    private SwimDiscipline discipline;

    public Result(int time, Date date, SwimDiscipline discipline){
        this.time = time;
        this.date = date;
        this.discipline = discipline;
    }

    public int getTime() {
        return time;
    }
    public Date getDate() {
        return date;
    }
    public SwimDiscipline getDiscipline(){
        return discipline;
    }

    @Override
    public int compareTo(Result o) {
        if (time < o.getTime()) {
            return 1;
        } else if (time > o.getTime()) {
            return -1;
        } else
            return 0;
    }
    @Override
    public String toString(){
        return "Time: " + time + " discipline: " + getDiscipline();
    }

}