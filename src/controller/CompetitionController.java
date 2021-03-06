package controller;
// @Author Lærke

import model.admin.Member;
import model.admin.MemberList;
import model.coach.SwimmerProfile;
import model.coach.TournamentResult;
import model.coach.TrainingResult;

import java.util.*;

public class CompetitionController {

    private MemberList memberList = MemberList.getInstance();

    // Hent CompetitionSwimmer fra liste
    public Member getCompetitionSwimmer(int memberID) {
        return this.memberList.getMember(memberID);
    }

    // Lav liste over CompetitionSwimmers
    public Collection<Member> listOfCompetitionSwimmers() {
        ArrayList<Member> listOfCompetitionSwimmers = new ArrayList<>();

        for (Member member : memberList.getMemberList()) {
            if(member.isCompetitionSwimmer()) {
                listOfCompetitionSwimmers.add(member);
            }
        }
        return listOfCompetitionSwimmers;
    }

    // Liste over junior CompetitionSwimmers - afgrænsning: alder
    public Collection<Member> juniorTeamList() {
        ArrayList<Member> juniorTeamList = new ArrayList<>();
        for (Member member : listOfCompetitionSwimmers()){
            if (member.getAge() < 18){
                juniorTeamList.add(member);
            }
        }
        return juniorTeamList;
    }

    // Liste over senior CompetitionSwimmers - afgrænsning: alder
    public Collection<Member> seniorTeamList() {
        ArrayList<Member> seniorTeamList = new ArrayList<>();
        for (Member member : listOfCompetitionSwimmers()){
            if(member.getAge() >= 18){
                seniorTeamList.add(member);
            }
        }
        return seniorTeamList;
    }

    // Tilføj turneringsresultatresultat til svømmeprofil
    public void addNewTournamentResult(int memberID, TournamentResult tournamentResult) {
        // Hent member/competitionsswimmers svømmeprofil
        SwimmerProfile swimmerProfile = getCompetitionSwimmer(memberID).getSwimmerprofile();
        // Tilføj turneringsresultat til medlems svømmeprofil
        swimmerProfile.logResult(tournamentResult);
    }

    // Tilføj træningsresultat til svømmeprofil
    public void addNewTrainingResult(int memberID, TrainingResult trainingResult) {
        // Hent member/competitionsswimmers svømmeprofil
        SwimmerProfile swimmerProfile = getCompetitionSwimmer(memberID).getSwimmerprofile();
        // Tilføj træningssresultat til medlems svømmeprofil
        swimmerProfile.logResult(trainingResult);
    }

    // Liste over top5 træningstid til udtagelse til competition

    public Collection<Member> topFiveMembers(String discipline) {
        // Hent aktive svømmere og disses svømmeprofiler
        Collection<Member> listOfCompetitionSwimmers = listOfCompetitionSwimmers();

        // Udvælg træningsresultater for given svømmedisciplin
        ArrayList<MemberAndTrainingResult> competitionSwimmerAndBestResult = new ArrayList<>();

        for (Member member : listOfCompetitionSwimmers){
            List<TrainingResult> trainingResults = member.getSwimmerprofile().getTrainingResults();
            // Spring svømmere uden træningsresultater over
            if (trainingResults.size() == 0) {
                continue;
            }

            ArrayList<TrainingResult> resultsForDiscipline = new ArrayList<>();
            for (TrainingResult trainingResult : trainingResults){
                if (trainingResult.getDiscipline().getType().equals(discipline)){
                    resultsForDiscipline.add(trainingResult);
                }
            }
            // Sortér træningsresultat efter tid
            Collections.sort(resultsForDiscipline);
            TrainingResult bestTrainingResult = resultsForDiscipline.get(0);
            competitionSwimmerAndBestResult.add(new MemberAndTrainingResult(member, bestTrainingResult));
        }

        Collections.sort(competitionSwimmerAndBestResult);

        // Udvælg de fem bedste svømmere i svømmedisciplinen og returner dem
        ArrayList<Member> top5 = new ArrayList<>();
        for (MemberAndTrainingResult record : competitionSwimmerAndBestResult) {
            if (top5.size() < 5) {
                top5.add(record.member);
            } else {
                break;
            }
        }
        return top5;
    }

    //Sammenkobling af medlem og resultat
    private class MemberAndTrainingResult implements Comparable<MemberAndTrainingResult>{
        Member member;
        TrainingResult trainingResult;

        MemberAndTrainingResult(Member member, TrainingResult trainingResult)
        {
            this.member = member;
            this.trainingResult = trainingResult;
        }

        @Override
        public int compareTo(MemberAndTrainingResult o) {
            return this.trainingResult.compareTo(o.trainingResult);
        }
    }
}
//Udvidelsespunkt: Konkurrencesvømmerne er inddelt i 2 hold efter alder. Ungdomsholdet er for svømmere under 18 år. Seniorholdet er for svømmere på 18 og over.
