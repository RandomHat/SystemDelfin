package model.coach;
// @Author Lærke

import java.util.*;

public class SwimmerProfile {

    ArrayList<TrainingResult> listOfTrainingResults = new ArrayList<>();
    ArrayList<TournamentResult> listOfTournamentResults = new ArrayList<>();

    //Registrer træningsresultat
    public void logResult(TrainingResult trainingResult){
        listOfTrainingResults.add(trainingResult);
    }

    //Find træningsresultat
    public List<TrainingResult> getTrainingResults(){
        return listOfTrainingResults;
    }

    //Registrer turneringsresultat
    public void logResult(TournamentResult tournamentResultResult){
        listOfTournamentResults.add(tournamentResultResult);
    }

    public ArrayList<Result> listOfResults(){
        ArrayList<Result> list = new ArrayList<>();

        for(int i = 0; i< listOfTournamentResults.size();i++){
            list.add(listOfTournamentResults.get(i));
        }

        for(int i = 0; i < listOfTrainingResults.size(); i++){
            list.add(listOfTrainingResults.get(i));
        }

        return list;
    }
    //Udvidelsespunkt: Konkurrencesvømmerne har tilknyttet en træner.
    //Udvidelsespunkt: Hver konkurrencesvømmer er desuden registreret i forhold til hvilke svømmediscipliner, svømmeren er aktiv i. competesIn


}
