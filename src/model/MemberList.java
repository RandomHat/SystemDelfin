package model;

import java.util.*;

public class MemberList {

    // Singleton pattern?
    private MemberList(){}
    private static final MemberList instance = new MemberList();

    // Has a counter to keep user ID's unique
    int memberIDCounter = 1;

    // Map of members
    private final Map<Integer, Member> memberList = new HashMap<>();


    public Member createMember(String name, String dateOfBirth, String gender, boolean isActiveMember, int phone, String email, String address){
        Member member = new Member(name, dateOfBirth, gender, isActiveMember, phone, email, address, memberIDCounter);
        memberIDCounter++;
        return member;
    }

    public void removeMember(int memberID){
        memberList.remove(memberID);
    }

    public void addMember(Member member){
        memberList.put(member.getId(), member);
    }

    public Member getMember(int memberID){
        return memberList.get(memberID);
    }

    public static MemberList getInstance() {
        return instance;
    }
}
