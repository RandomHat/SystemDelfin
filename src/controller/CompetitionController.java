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
        //skal bruge markør for junior, for at kunne trække en liste af juniorer

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
        // Hent aktive svømmere og disses svømmeprofiler.
        // Gruppér de udvalgte svømmeres træningsresultater på den angivne svømmedisciplin.
        // Sortér træningsresultat efter tid.
        // Udvælg de fem bedste svømmere i svømmedisciplinen og returner dem.

        ArrayList<MemberAndTrainingResult> membersWithBestResult = new ArrayList<>();

        for (Member member : listOfCompetitionSwimmers()) {
            TrainingResult bestResult = member.getSwimmerprofile().findBestTrainingResult(new SwimDiscipline(0000, discipline));
            membersWithBestResult.add(new MemberAndTrainingResult(member, bestResult));
        }

        Collections.sort(membersWithBestResult);
        ArrayList<Member> top5 = new ArrayList<>();
        for (MemberAndTrainingResult result : membersWithBestResult) {
            if (top5.size() < 5)
            {
                top5.add(result.member);
            }

            break;
        }

        return top5;
    }

    //sammenkobling af medlem og resultat

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

//Inden for hver svømmedisciplin registreres den enkelte svømmers bedste træningsresultat og dato
//løbende. For de svømmere, der har deltaget i konkurrencer, registreres stævne, placering og tid. Det er på
//baggrund af de enkelte svømmeres resultater, at træneren udtager svømmere til deltagelse i konkurrencer.
//Træneren ønsker derfor en oversigt, der kan vise klubbens top 5 svømmere inden for hver svømmedisciplin
//(butterfly, crawl, rygcrawl og brystsvømning), fordelt på henholdsvis junior og seniorsvømmere.