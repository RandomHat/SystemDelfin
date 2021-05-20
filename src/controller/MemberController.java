package controller;

import model.Member;
import model.MemberList;

import java.util.Scanner;

public class MemberController {

    MemberList memberList = MemberList.getInstance();

    public void listOfMembers(){
        for (Member currentMember: memberList.getMemberList()){
            System.out.println(currentMember);
        }
    }

    public Member getMember(int memberID){
        return memberList.getMember(memberID);
    }

    public void showMember(int memberID){
        System.out.println(memberList.getMember(memberID));
    }

    public void addMember(String name, String dateOfBirth, String gender, boolean isActiveMember, int phone, String email, String address){
        Member member = new Member(name, dateOfBirth, gender, isActiveMember, phone, email, address, memberList.getMemberIDCounter());
        memberList.addMember(member);
    }


    public void editMember(int memberID, int choice) {
        //skal bruge en masse setter
        switch (choice) {
            case 1:
                memberList.getMember(memberID).setName("blank"); //TODO find ud af at løse scanner input ting.
            case 2:
                memberList.getMember(memberID).setDateofbirth("");
            case 3:
                memberList.getMember(memberID).setGender("");
            case 4:
                memberList.getMember(memberID).setIsactivemember(true);
            case 5:
                memberList.getMember(memberID).setPhone(2222222);
            case 6:
                memberList.getMember(memberID).setEmail("");
            case 7:
                memberList.getMember(memberID).setAdress("");
        }
    }

    public void deleteMember() {
        Scanner removemember = new Scanner(System.in);
        System.out.println("Enter ID of the person you want to remove");
    }
}


















