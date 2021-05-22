package controller;
// @Author Lærke

import model.Member;
import model.MemberList;
import java.util.*;

public class CompetitionController {

    private MemberList memberList = MemberList.getInstance();


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

    //opret turneringsresultatresultat TODO
    public void addNewTournamentResult(int memberID, double time, Date date, int distance, String type, String tournamentName, int placement) {
        //addResult skal tage et memberID, trække Svømmeprofil ud og tilføje et resultat til medlemmets svømmeprofil
    }

    //opret træningsresultat TODO
    public void addNewResult(int memberID, double time, Date date, int distance, String type) {
        //addResult skal tage et memberID, trække Svømmeprofil ud og tilføje et resultat til medlemmets svømmeprofil
    }

    //tilføj disciplin TODO

    //liste over top5 træningstid til udtagelse til competition
    public Collection<Member> topFiveMembers(String discipline) { //TODO
        return null;
    }
}

