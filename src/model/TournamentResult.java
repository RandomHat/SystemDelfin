package model;

import java.util.Date;

public class TournamentResult extends Result{

    private int placement;
    private String tournament;

    TournamentResult(int time, Date date, int placement, String tournament){
        super(time, date);
        this.placement = placement;
        this.tournament = tournament;
    }





}
