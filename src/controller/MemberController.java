package controller;

import model.Member;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemberController {

    public Member createMember(String name, String dateOfBirth, String gender, boolean isActiveMember, int phone, String email, String address){
        Member member = new Member(name, dateOfBirth, gender, isActiveMember, phone, email, address, 6);
        memberList.addMember(member);
    }


public static void editMember() {
//skal bruge en masse settere

}

public void deleteMember() {
    Scanner removemember = new Scanner(System.in);
    System.out.println("Enter ID of the person you want to remove");


}


















