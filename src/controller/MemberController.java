package controller;

import model.Member;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemberController {
    Member member1 = new Member("Dennis", "19 juli 1998", "mand", true, 69696969,
            "dennis@gmail.com", "dennisvej69", 1);
}

public static void AddMember() throws FileNotFoundException{
    Scanner newmember = new Scanner(System.in);
    System.out.println("Enter nae: ");
    String name = newmember.nextLine();
    System.out.println("Enter Birthday: ");
    String birthday = newmember.nextLine();
}

public static void EditMember() throws FileNotFoundException{
//skal bruge en masse settere

}

public static void DeleteMember() throws FileNotFoundException{


}