package View;

import controller.CompetitionController;
import controller.MemberController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewController {

    private final CompetitionController competitionController = new CompetitionController();
    private final MemberController memberController = new MemberController();

    public void AddMember() throws FileNotFoundException {
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
        memberController.addMember(name, birthday, gender, active, phonenumber, Email, address);
    }

    public void mainMenu(){

        System.out.println("[1] Show members"); //TODO lave en liste der kan printes i MemberController som indeholder Navn, Alder og Exerciser/Comp Swimmer
        System.out.println("[2] Add new member");
        System.out.println("[3] Coach options");
        System.out.println("[4] Exit program" );

    }

    /**
     * Coach option under menu
     */
    public void coachMenu(){

        System.out.println("[1] Show Competition Swimmers");
        System.out.println("[2] Add new Training result");
        System.out.println("[3] Add new Competition result");
        System.out.println("[4] Back to Main Menu");
    }

    /**
     * Add new member under menu
     */
    public void newMemberMenu(){
        System.out.println("[1] Exerciser"); //TODO man skal kunne vælge om det er en Exerciser eller competetion swimmer
        System.out.println("[2] Competition Swimmer");//TODO man skal kunne vælge om det er en Exerciser eller competetion swimmer
        System.out.println("[3] Back to Main Menu");

    }

    /**
     * show members under menu
     */
    public void memberInfo(){
        System.out.println("[1] Show member details"); //TODO print detaljer om Members
        System.out.println("[3] show Active members"); // TODO print liste over active members
        System.out.println("[4] show Passive members");// TODO print liste over passive members
        System.out.println("[5] Back to Main Menu");
    }

    /**
     * Main menu Switch
     */
    public void menu(){
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running) {
            mainMenu();
            switch (menuChoice.nextInt()) {

                case 1:
                    memberController.listOfMembers();
                    memberInfo();

            }
        }
    }

    /**
     * showMembers Switch
     */
    public void showMembers(){
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running){
            switch (menuChoice.nextInt()) {

                case 1:
                    int memberID = menuChoice.nextInt();
                    memberController.showMemberDetails(memberID);

            }
        }
    }

}
