package model;
// @Author Lærke


import java.util.ArrayList;

public class SwimmerProfile {

    ArrayList<TrainingResult> listOfTrainingResults = new ArrayList<>();
    ArrayList<TournamentResult> listOfTournamentResults = new ArrayList<>();

    public void logResult(TrainingResult trainingResult){
        listOfTrainingResults.add(trainingResult);
    }
    public void logResult(TournamentResult tournamentResultResult){
        listOfTournamentResults.add(tournamentResultResult);
    }

    //Udvidelsespunkt: Konkurrencesvømmerne har tilknyttet en træner.
    //Udvidelsespunkt: Konkurrencesvømmerne er inddelt i 2 hold efter alder. Ungdomsholdet er for svømmere under 18 år. Seniorholdet er for svømmere på 18 og over.
    //Udvidelsespunkt: Hver konkurrencesvømmer er desuden registreret i forhold til hvilke svømmediscipliner, svømmeren er aktiv i. competesIn


}
