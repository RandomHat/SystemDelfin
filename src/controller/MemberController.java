package controller;

import model.Member;
import model.MemberList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MemberController {

    MemberList memberList = MemberList.getInstance();

    public Collection<Member> getMemberList(){
        return memberList.getMemberList();
    }

    public Member getMember(int memberID){
        return memberList.getMember(memberID);
    }

    public void showMember(int memberID){
        System.out.println(memberList.getMember(memberID));
    }

    public void addMember(String name, String dateOfBirth, String gender, boolean isActiveMember, int phone, String email, String address, boolean isCompetitionSwimmer){
        Member member = new Member(name, dateOfBirth, gender, isActiveMember, phone, email, address, memberList.getMemberIDCounter());
        member.setCompetitionSwimmer(isCompetitionSwimmer); // new, angiver om medlem er konkurrencesvømmer
        memberList.addMember(member);
    }


    public void editMember(int memberID, int choice) {
        //skal bruge en masse setter
        switch (choice) {
            case 1:
                memberList.getMember(memberID).setName("blank"); //TODO find ud af at løse scanner input ting.
            case 2:
                memberList.getMember(memberID).setDateOfBirth("");
            case 3:
                memberList.getMember(memberID).setGender("");
            case 4:
                memberList.getMember(memberID).setActiveMember(true);
            case 5:
                memberList.getMember(memberID).setPhone(2222222);
            case 6:
                memberList.getMember(memberID).setEmail("");
            case 7:
                memberList.getMember(memberID).setAdress("");
        }
    }
    public void editMemberName(int memberID, String name){
        memberList.getMember(memberID).setName(name);
    }
    public void editMemberDateOfBirth(int memberID, String Dateofbirth){
        memberList.getMember(memberID).setDateOfBirth(Dateofbirth);
    }
    public void editMemberGender(int memberID, String gender){
        memberList.getMember(memberID).setGender(gender);
    }
    public void editMemberIsActiveMember(int memberID, boolean Isactivemember){
        memberList.getMember(memberID).setActiveMember(Isactivemember);
    }
    public void editMemberPhone(int memberID, int phone){
        memberList.getMember(memberID).setPhone(phone);
    }
    public void editMemberEmail(int memberID, String email){
        memberList.getMember(memberID).setEmail(email);
    }
    public void editMemberAdress(int memberID, String adress){
        memberList.getMember(memberID).setAdress(adress);
    }

    public void deleteMember() {
        Scanner removemember = new Scanner(System.in);
        System.out.println("Enter ID of the person you want to remove");
    }

    public Collection<Member> activeMemberList(){
        return sortForActivity(true);
    }

    public Collection<Member> passiveMemberList(){
        return sortForActivity(false);
    }

    private Collection<Member> sortForActivity(boolean activity){
        List<Member> listToSort = new ArrayList<>();
        for (Member currentMember: memberList.getMemberList()) {
            if (currentMember.isActiveMember() == activity) {
                listToSort.add(currentMember);
            }
        }
        return listToSort;
    }
}


















