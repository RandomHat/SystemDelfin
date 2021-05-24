package model;

import java.util.*;

public class MemberList {
    // @Author Simon Roswall Jørgensen

    // Singleton mønster?
    private MemberList(){
    }
    private static final MemberList instance = new MemberList();

    public static MemberList getInstance() {
        return instance;
    }

    // Has a counter to keep user ID's unique
    int memberIDCounter = 1;

    // Map of members
    private final Map<Integer, Member> memberList = new HashMap<>();

    public Collection<Member> getMemberList() {
        return memberList.values();
    }

    public void removeMember(int memberID){
        memberList.remove(memberID);
    }

    public void addMember(Member member){
        memberList.put(member.getId(), member);
        memberIDCounter++;
    }

    public int getMemberIDCounter(){
        return memberIDCounter;
    }

    public void setMemberIDCounter(int memberID){
        this.memberIDCounter = memberID;
    }

    public Member getMember(int memberID){
        return memberList.get(memberID);
    }
}
