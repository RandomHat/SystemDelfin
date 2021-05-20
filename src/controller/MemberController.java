package controller;

import model.Member;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemberController {
    Member member1 = new Member("Dennis", "19 juli 1998", "mand", true, 69696969,
            "dennis@gmail.com", "dennisvej69", 1);
}

public static void addMember() {
    Scanner newmember = new Scanner(System.in);
    System.out.println("Enter name: ");
    String name = newmember.nextLine();
    System.out.println("Enter Birthday: ");
    String birthday = newmember.nextLine();
    System.out.println("Enter Gender");
    String gender = newmember.nextLine();
    System.out.println("Is the member active inactive?");
    Boolean active = newmember.nextBoolean();
    System.out.println("Enter phone number");
    Integer phonenumber = newmember.nextInt();
    System.out.println("Enter email address");
    String Email =  newmember.nextLine();
    System.out.println("Enter Address");
    String address = newmember.nextLine();
    System.out.println("Enter new member ID");
    Integer ID = newmember.nextInt();
}

public static void editMember() {
//skal bruge en masse settere

}

public void deleteMember() {
    Scanner removemember = new Scanner(System.in);
    System.out.println("Enter ID of the person you want to remove");


}


















