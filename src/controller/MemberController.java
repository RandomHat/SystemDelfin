package controller;

import model.Member;
import model.MemberList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemberController {

    //

    MemberList memberList = MemberList.getInstance();

    public Collection<Member> getMemberList(){
        return memberList.getMemberList();
    }

    public Member getMember(int memberID){
        return memberList.getMember(memberID);
    }

    public void addMember(String name, int age, String gender, boolean isActiveMember, int phone, String email, String address, boolean isCompetitionSwimmer){
        Member member = new Member(memberList.getMemberIDCounter(), name, age, gender, isActiveMember, phone, email, address, isCompetitionSwimmer);
        memberList.addMember(member);
    }

    public void editMemberName(int memberID, String name){
        memberList.getMember(memberID).setName(name);
    }
    public void editMemberDateOfBirth(int memberID, int age){
        memberList.getMember(memberID).setAge(age);
    }
    public void editMemberGender(int memberID, String gender){
        memberList.getMember(memberID).setGender(gender);
    }
    public void editMemberIsActiveMember(int memberID, boolean Isactivemember){
        memberList.getMember(memberID).setActiveMember(Isactivemember);
    }
    public void editMemberPhone(int memberID, int phone){ memberList.getMember(memberID).setPhone(phone); }
    public void editMemberEmail(int memberID, String email){
        memberList.getMember(memberID).setEmail(email);
    }
    public void editMemberAdress(int memberID, String adress){
        memberList.getMember(memberID).setAdress(adress);
    }

    public void memberToRemove(int memberID) {
        memberList.removeMember(memberID);

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


















