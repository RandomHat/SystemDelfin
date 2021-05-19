package model;

import java.util.Date;

public class TournamentResult extends Result implements Comparable<TournamentResult>{

    private int placement;
    private String tournament;

    TournamentResult(int time, Date date, int placement, String tournament){
        super(time, date);
        this.placement = placement;
        this.tournament = tournament;
    }

    public int getPlacement(){
        return placement;
    }

    public String getTournament(){
        return tournament;
    }

    @Override
    public int compareTo(TournamentResult o) {
        if(placement > o.placement){
            return 1;
        }else if(placement < o.placement){
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

    /*
    @Override
    public int compareResults(TournamentResult o, TrainingResult j) {
        o.getTime();
        return 0;
    }
    */

}
