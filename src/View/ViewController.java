package View;

import controller.CompetitionController;
import controller.MemberController;
import model.CompetitionSwimmer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewController {

    private final CompetitionController competitionController = new CompetitionController();
    private final MemberController memberController = new MemberController();

    public void addMember(){
        Scanner newmember = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = newmember.nextLine();
        System.out.println("Enter Birthday: ");
        String birthday = newmember.nextLine();
        System.out.println("Enter Gender");
        String gender = newmember.nextLine();
        System.out.println("Is the member active inactive?");
        Boolean active = newmember.nextBoolean(); //TODO måske bare være active som udgangspunkt?
        System.out.println("Enter phone number");
        int phonenumber = newmember.nextInt();
        System.out.println("Enter email address");
        String Email =  newmember.nextLine();
        System.out.println("Enter Address");
        String address = newmember.nextLine();
        memberController.createMember(name, birthday, gender, active, phonenumber, Email, address);
    }

    public void editMember() throws InputMismatchException{
        Scanner editmember = new Scanner(System.in);
        System.out.println("Enter memberID");
        int ID = editmember.nextInt();
        memberController.showMember(ID);
        System.out.println("Choose the information you want to change");
        System.out.println("[1] Name");
        System.out.println("[2] Date of birth");
        System.out.println("[3] Gender");
        System.out.println("[4] Activity status");
        System.out.println("[5] Phone number");
        System.out.println("[6] Email");
        System.out.println("[7] Adress");
        System.out.println("[8] Cancel and return to menu");
        int choice = editmember.nextInt();
        if(choice >= 1 && choice < 8){
            memberController.editMember(ID, choice);
        } else if(choice == 8) {

        } else {
            throw new InputMismatchException();
        }

    }

    public void mainMenuText(){

        System.out.println("[1] Show members"); //TODO lave en liste der kan printes i MemberController som indeholder Navn, Alder og Exerciser/Comp Swimmer
        System.out.println("[2] Add new member");
        System.out.println("[3] Coach options");
        System.out.println("[4] Exit program" );

    }

    /**
     * Coach option under menu
     */
    public void coachMenuText(){
        System.out.println("[1] Show Competition Swimmers");
        System.out.println("[2] Add new Training result");
        System.out.println("[3] Add new Competition result");
        System.out.println("[4] Back to Main Menu");
    }

    public void coachMenu(){
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running){
            coachMenuText();
            switch(menuChoice.nextInt()){
                case 1:
                    printCompetitionSwimmers();
                    competitionController.showCompetitionSwimmers(); //TODO en print venlig liste af competitionSwimmers
                    break;
                case 2:
                    addNewResult();
                    competitionController.addNewResult()

            }
        }
    }

    /**
     * Add new member under menu
     */
    public void newMemberMenuText(){
        System.out.println("[1] Exerciser"); //TODO man skal kunne vælge om det er en Exerciser eller competetion swimmer
        System.out.println("[2] Competition Swimmer");//TODO man skal kunne vælge om det er en Exerciser eller competetion swimmer
        System.out.println("[3] Back to Main Menu");

    }

    /**
     * show members under menu
     */
    public void showMembersText(){
        System.out.println("[1] Show member details"); //TODO print detaljer om Members
        System.out.println("[2] Edit member");
        System.out.println("[3] show Active members"); // TODO print liste over active members
        System.out.println("[4] show Passive members");// TODO print liste over passive members
        System.out.println("[5] Back to Main Menu");
    }

    /**
     * Main menu Switch
     */
    public void mainMenu() throws InputMismatchException{
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running) {
            mainMenu();
            switch (menuChoice.nextInt()) {

                case 1:
                    memberController.listOfMembers();
                    showMembersMenu();
                    break;
                case 2:
                    addMember();
                    break;
                case 3: // Coach options


            }
        }
    }

    /**
     * showMembersMenu Switch
     */
    public void showMembersMenu() throws InputMismatchException{
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;

        showMembersText();
        try{
            while(running){

                switch (menuChoice.nextInt()) {

                    case 1: // show memberlist -> vælg memberDetails
                        System.out.println("Member ID: ");
                        memberController.showMemberDetails(integerInput());
                        break;
                    case 2: //Edit member
                        System.out.println("Member ID: ");
                        editMember();
                        break;
                    case 3: //active members -> viser liste med active members
                        memberController.showActiveMemberList(); // TODO liste over Aktive medlemmer
                        break;
                    case 4: //passive members -> viser liste med de passive members
                        memberController.showPassiveMemberList(); //TODO liste over Passive medlemmer
                        break;
                    case 5: // Back to mainMenu
                        running = false;
                        break;
                }

            }
        }
        catch (InputMismatchException e){
            System.out.println("Wrong input");
        }
    }

    public void printCompetitionSwimmers(){
        Collection<CompetitionSwimmer> competitionSwimmers = competitionController.CompetitionSwimmers(); //TODO Collection af CompetitionSwimmers

        for(int i = 0; i<competitionSwimmers.toArray().length;i++){
            System.out.println(competitionSwimmers.toArray()[i]);
        }
    }

    public int integerInput() throws InputMismatchException {
        Scanner userInteger = new Scanner(System.in);
        int choice;

        if(userInteger.hasNextInt()){
            choice = userInteger.nextInt();
        } else{
            throw new InputMismatchException(); // exception "Input Out of Bounds"
        }

        return choice;
    }
    public String stringInput() throws InputMismatchException {
        Scanner userString = new Scanner(System.in);
        return userString.nextLine();
    }
}
