package controller;

import model.admin.Member;
import model.admin.MemberList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/* @Author Simon Roswall Jørgensen
*
* Klassen står for at indlæse og lagre MemberListen til en csv-fil. Path er hardcoded og lagring af træningsresultater er ikke implementeret endnu.
* */

public class SaveLoadController {
    private final MemberList MEMBER_LIST = MemberList.getInstance();

    public void loadMemberList() throws FileNotFoundException{
        Scanner reader = new Scanner(new File("Swimclub_Save_Files/MemberLog.csv"));
        reader.nextLine();
        int countCorrectID = 1;
        while(reader.hasNext()){

            // Læser og splitter saveString
            String currentLine = reader.nextLine();
            String[] attributes = currentLine.trim().split(";");

            // Laver og adder member til listen
            MEMBER_LIST.addMember( new Member(Integer.parseInt(attributes[0]),attributes[1],Integer.parseInt(attributes[2]),
                    attributes[3], Boolean.parseBoolean(attributes[4]),Integer.parseInt(attributes[5]),attributes[6],
                    attributes[7],Boolean.parseBoolean(attributes[8])));


            // Korrigerer memberIDCounter for at holde dem unikke.
            if(countCorrectID < Integer.parseInt(attributes[0])){
                countCorrectID = Integer.parseInt(attributes[0]);
            }
        }
        MEMBER_LIST.setMemberIDCounter(countCorrectID);
    }


    public void saveMemberList() throws FileNotFoundException {
        PrintStream output = new PrintStream("Swimclub_Save_Files/MemberLog.csv");
        output.println("memberID;Name;Age;Gender;isactivemember;phone;email;adress;competitionSwimmer");
        for (Member currentMember : MEMBER_LIST.getMemberList()) {
            output.println(convertToSaveString(currentMember));
        }
    }

    // Læser Attributes og gemmer dem i en csv-string
    private String convertToSaveString(Member member){
        return member.getId() + ";" + member.getName() + ";" + member.getAge() +";" + member.getGender() + ";" +
                member.isActiveMember() + ";" + member.getPhone() + ";" + member.getEmail() + ";" + member.getAdress() +
                ";" + member.isCompetitionSwimmer();
    }
}
