package model.admin;

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

    // Tæller som sørger for unikke memberID'er
    int memberIDCounter = 1;

    // <Key, Value> hashmap collection af members så man kan finde Members direkte på memberID.
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
