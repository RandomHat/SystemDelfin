package controller;
// @Author Lærke

import model.*;

import java.util.*;

public class CompetitionController {

    private MemberList memberList = MemberList.getInstance();

    //hent CompetitionSwimmer fra liste
    public Member getCompetitionSwimmer(int memberID) {
        return this.memberList.getMember(memberID);
    }

    //lav liste over CompetitionSwimmers
    public Collection<Member> listOfCompetitionSwimmers() {
        ArrayList<Member> listOfCompetitionSwimmers = new ArrayList<>();

        for (Member member : memberList.getMemberList()) {
            if(member.isCompetitionSwimmer()) {
                listOfCompetitionSwimmers.add(member);
            }
        }
        return listOfCompetitionSwimmers;
    }

    //liste over junior CompetitionSwimmers - alternativt ind i SwimmerProfile TODO
    public Collection<Member> juniorTeamList() {
        return null;
    }

    // liste over senior CompetitionSwimmers - alternativt ind i SwimmerProfile TODO
    public Collection<Member> seniorTeamList() {
        return null;
    }

    //tilføj turneringsresultatresultat til svømmeprofil
    public void addNewTournamentResult(int memberID, TournamentResult tournamentResult) {
        //hent member/competitionsswimmers svømmeprofil
        SwimmerProfile swimmerProfile = getCompetitionSwimmer(memberID).getSwimmerprofile();
        //tilføj turneringsresultat til medlems svømmeprofil
        swimmerProfile.logResult(tournamentResult);
    }

    //tilføj træningsresultat til svømmeprofil
    public void addNewTrainingResult(int memberID, TrainingResult trainingResult) {
        //hent member/competitionsswimmers svømmeprofil
        SwimmerProfile swimmerProfile = getCompetitionSwimmer(memberID).getSwimmerprofile();
        //tilføj træningssresultat til medlems svømmeprofil
        swimmerProfile.logResult(trainingResult);
    }

    //liste over top5 træningstid til udtagelse til competition
    public Collection<Member> topFiveMembers(String discipline) { //TODO
        return null;
    }
}

//Inden for hver svømmedisciplin registreres den enkelte svømmers bedste træningsresultat og dato
//løbende. For de svømmere, der har deltaget i konkurrencer, registreres stævne, placering og tid. Det er på
//baggrund af de enkelte svømmeres resultater, at træneren udtager svømmere til deltagelse i konkurrencer.
//Træneren ønsker derfor en oversigt, der kan vise klubbens top 5 svømmere inden for hver svømmedisciplin
//(butterfly, crawl, rygcrawl og brystsvømning), fordelt på henholdsvis junior og seniorsvømmere.