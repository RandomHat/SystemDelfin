package model.coach;

import java.util.Date;
//@Author Mark Kaplan Hansen
public class TournamentResult extends Result{

    private int placement;
    private String tournament;

    public TournamentResult(int time, Date date, SwimDiscipline discipline, int placement, String tournament){
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
    public String toString(){
        return "Tournament: " + tournament + "\n" +
                "Placement: " + placement + "\n" +
                super.toString();
    }
}
