package controller;

import model.CompetitionSwimmer;
import model.Member;
import model.MemberList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class SaveLoadController {
    MemberList memberList = MemberList.getInstance();

    public void loadMemberList() throws FileNotFoundException{
        Scanner reader = new Scanner(new File("Swimclub_Save_Files/MemberLog.csv"));
        reader.nextLine();
        while(reader.hasNext()){
            String currentLine = reader.nextLine();
            String[] attributes = currentLine.trim().split(";");
            if (Boolean.parseBoolean(attributes[8])){
                memberList.addMember(new CompetitionSwimmer(attributes[0],attributes[1],attributes[2],attributes[3],attributes[4],attributes[5],attributes[6],attributes[7]));
            }
            else
                memberList.addMember(new Member(attributes[0],attributes[1],attributes[2],attributes[3],attributes[4],attributes[5],attributes[6],attributes[7]));
        }
    }

    public void saveMemberList() throws FileNotFoundException {
        PrintStream output = new PrintStream("Swimclub_Save_Files/MemberLog.csv");
        output.println("memberID;Name;Age;Gender;isactivemember;phone;email;adress;competitionSwimmer");
        for (Member currentMember : memberList.getMemberList()) {
            output.println(convertToSaveString(currentMember));
        }
    }

    public String convertToSaveString(Member member){
        return member.getId() + ";" + member.getName() + ";" + member.getDateOfBirth() +";" + member.getGender() + ";" + member.isActiveMember() + ";" + member.getPhone() + ";" +
            member.getEmail() + ";" + member.getAdress() + ";" + member.isCompetitionSwimmer();
    }
}
