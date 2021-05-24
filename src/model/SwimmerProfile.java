package model;
// @Author Lærke

import java.util.*;

public class SwimmerProfile {

    // Træningsresultat grupperet på svømmedisciplin.
    Map<SwimDiscipline, ArrayList<TrainingResult>> trainingResults = new HashMap<>();

    public void logResult(TrainingResult trainingResult){
        // Erklær arrayliste til opbevaring af træningsresultater.
        ArrayList<TrainingResult> trainingResults;
        // Udtræk svømmedisciplin fra træningsresultat.
        SwimDiscipline discipline = trainingResult.getDiscipline();
        // Tjek om svømmedisciplinen indgår i træningsresultaterne.
        if (this.trainingResults.containsKey(discipline)) {
            // Hvis disciplinen indgår, sættes "trainingResults" lig med den eksisterende liste af træningsresultater.
            trainingResults = this.trainingResults.get(discipline);
        } else {
            // Hvis disciplinen ikke indgår, sættes "trainingResults" lig med en ny og tom liste af træningsresultater.
            trainingResults = new ArrayList<>();
            // Den nyoprettede liste tilføjes til "this.trainingResults" med "discipline" som nøgle.
            this.trainingResults.put(discipline, trainingResults);
        }
        // Træningsresultat tilføjes til "trainingResults".
        trainingResults.add(trainingResult);
    }

    public List<TrainingResult> getTrainingResults(SwimDiscipline discipline)
    {
        ArrayList<TrainingResult> trainingResults = this.trainingResults.get(discipline);

        if(trainingResults == null)
        {
            return new ArrayList<>();
        }

        Collections.sort(trainingResults);
        return trainingResults;
    }

    public TrainingResult findBestTrainingResult(SwimDiscipline discipline)
    {
        return getTrainingResults(discipline).get(this.trainingResults.size() - 1);
    }

    ArrayList<TrainingResult> listOfTrainingResults = new ArrayList<>();
    ArrayList<TournamentResult> listOfTournamentResults = new ArrayList<>();

    /*public void logResult(TrainingResult trainingResult){
        listOfTrainingResults.add(trainingResult);
    }*/
    public void logResult(TournamentResult tournamentResultResult){
        listOfTournamentResults.add(tournamentResultResult);
    }

    //Udvidelsespunkt: Konkurrencesvømmerne har tilknyttet en træner.
    //Udvidelsespunkt: Hver konkurrencesvømmer er desuden registreret i forhold til hvilke svømmediscipliner, svømmeren er aktiv i. competesIn


}
