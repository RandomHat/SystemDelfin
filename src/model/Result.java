package model;

import java.util.Date;

public abstract class Result {
    int time;
    Date date;

    public Result(int time, Date date){
        this.time = time;
        this.date = date;
    }
}
