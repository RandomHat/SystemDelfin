package controller;

import model.CompetitionSwimmer;
import model.Member;
import model.MemberList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CompetitionController {

    private MemberList member = MemberList.getInstance();

    // liste over hvad controller skal kunne

    //opret tider
    //find tider
    //have en liste over CompetitionSwimmers og kunne sortere efter bedste tid
    //Udtage til turneringer ud fra liste af Swimmers(Som har en liste med tider) i SwimDiscipline kategorien
    //tildele SwimDisciplines til CompetitionSwimmer
    //

    /**
     * laver competitionMembers  om fra members til Competitions
     * @return CompetitionSwimmer Map
     */
    public Map<Integer, CompetitionSwimmer> competitionSwimmerList(){
        Map<Integer, CompetitionSwimmer> competitionSwimmers = new HashMap<>();
        Member[] array = new Member[member.getMemberList().size()];

        for(int i = 0; i < array.length; i++)
        if(array[i] instanceof CompetitionSwimmer){
            CompetitionSwimmer currentMember = (CompetitionSwimmer) array[i];
            competitionSwimmers.put(member.getMember(i).getId(),currentMember);
        }
        return competitionSwimmers;
    }



}
