package model;

import java.util.Date;

public class TournamentResult extends Result{

    private int placement;
    private String tournament;

    TournamentResult(int time, Date date, SwimDiscipline discipline, int placement, String tournament){
        super(time, date, discipline);
        this.placement = placement;
        this.tournament = tournament;
    }

    public int getPlacement(){
        return placement;
    }

    public String getTournament(){
        return tournament;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    @Override
    public int compareTo(Result o) {

            if (super.getTime() > o.getTime()) {
                return 1;
            } else if (super.getTime() < o.getTime()) {
                return -1;
            } else
                return 0;
    }

    @Override
    public String toString(){
        return "Tournament: " + tournament + "\n" +
                "Placement: " + placement + "\n" +
                super.toString();
    }
}
