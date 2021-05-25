package controller;

import model.admin.Member;
import model.admin.MemberList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemberController {

    //

    private final MemberList MEMBER_LIST = MemberList.getInstance();

    public Collection<Member> getMemberList(){
        return MEMBER_LIST.getMemberList();
    }

    public Member getMember(int memberID){
        return MEMBER_LIST.getMember(memberID);
    }

    public void addMember(String name, int age, String gender, boolean isActiveMember, int phone, String email, String address, boolean isCompetitionSwimmer){
        Member member = new Member(MEMBER_LIST.getMemberIDCounter(), name, age, gender, isActiveMember, phone, email, address, isCompetitionSwimmer);
        MEMBER_LIST.addMember(member);
    }

    public void editMemberName(int memberID, String name){
        MEMBER_LIST.getMember(memberID).setName(name);
    }
    public void editMemberAge(int memberID, int age){
        MEMBER_LIST.getMember(memberID).setAge(age);
    }
    public void editMemberGender(int memberID, String gender){
        MEMBER_LIST.getMember(memberID).setGender(gender);
    }
    public void editMemberIsActiveMember(int memberID, boolean Isactivemember){
        MEMBER_LIST.getMember(memberID).setActiveMember(Isactivemember);
    }
    public void editMemberPhone(int memberID, int phone){ MEMBER_LIST.getMember(memberID).setPhone(phone); }
    public void editMemberEmail(int memberID, String email){
        MEMBER_LIST.getMember(memberID).setEmail(email);
    }
    public void editMemberAdress(int memberID, String adress){
        MEMBER_LIST.getMember(memberID).setAdress(adress);
    }

    public void memberToRemove(int memberID) {
        MEMBER_LIST.removeMember(memberID);

    }

    public Collection<Member> activeMemberList(){
        return sortForActivity(true);
    }

    public Collection<Member> passiveMemberList(){
        return sortForActivity(false);
    }

    private Collection<Member> sortForActivity(boolean activity){
        List<Member> listToSort = new ArrayList<>();
        for (Member currentMember: MEMBER_LIST.getMemberList()) {
            if (currentMember.isActiveMember() == activity) {
                listToSort.add(currentMember);
            }
        }
        return listToSort;
    }
}


















