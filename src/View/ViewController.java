package View;

import controller.CompetitionController;
import controller.MemberController;
import model.*;

import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewController {

    private final CompetitionController competitionController = new CompetitionController();
    private final MemberController memberController = new MemberController();

    //#region MainMenu

    /**
     * Main menu UI
     */
    public void mainMenuText(){

        System.out.println("[1] Show members"); //TODO lave en liste der kan printes i MemberController som indeholder Navn, Alder og Exerciser/Comp Swimmer
        System.out.println("[2] Add new member");
        System.out.println("[3] Coach options");
        System.out.println("[4] Exit program" );
    }

    /**
     * Main menu Switch
     */
    public void mainMenu() throws InputMismatchException{
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running) {
           // mainMenu(); rekursiv, kalder sig selv
            mainMenuText(); //skriver menu
            switch (menuChoice.nextInt()) {

                case 1:
                    printListOfMembers();
                    showMembersMenu();
                    break;
                case 2:
                    addMember();
                    break;
                case 3: // Coach options
                    coachMenu();
                    break;
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

    public void addMember(){
        newMemberMenuText(); // new, skal have valg af CS ind
        int subMenuChoice = integerInput();
        boolean isCompetitionSwimmer;

        if (subMenuChoice == 1){
            isCompetitionSwimmer = false;
        } else if (subMenuChoice == 2){
            isCompetitionSwimmer = true;
        } else {
            return; //slipper for at håndtere exceptions ved fejltastning
        }

        System.out.println("Enter name: ");
        String name = stringInput();
        System.out.println("Enter Birthday: ");
        String birthday = stringInput();
        System.out.println("Enter Gender");
        String gender = stringInput();
        Boolean active = true; //TODO måske bare være active som udgangspunkt?
        System.out.println("Enter phone number");
        int phonenumber = integerInput();
        System.out.println("Enter email address");
        String Email =  stringInput();
        System.out.println("Enter Address");
        String address = stringInput();
        memberController.addMember(name, birthday, gender, active, phonenumber, Email, address, isCompetitionSwimmer); // new
    }

    public void printListOfMembers() { // TODO lave en metode der returnere en liste over alle medlemmer;
        printMemberList(memberController.getMemberList());
    }
    //#endregion

    //#region Coach Menu
    /**
     * Coach option under menu
     */
    public void coachMenuText(){
        System.out.println("[1] Show Competition Swimmers");
        System.out.println("[2] Add new Training result");
        System.out.println("[3] Add new Competition result");
        System.out.println("[4] Top 5 Swimmers in Discipline");
        System.out.println("[5] Back to Main Menu");
    }

    public void coachMenu(){
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running){
            coachMenuText();
            switch(menuChoice.nextInt()){
                case 1:
                    printCompetitionSwimmers();
                    break;
                case 2:
                    addNewResult(false);
                    break;
                case 3:
                    addNewResult(true);
                    break;
                case 4:
                    printTopFive();
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }

    public void addNewResult(boolean isTournamentResult) {
        int team;
        int memberID;
        int time;
        int distance;
        String type;
        Date date;
        int year, month, day;

        findTeamText();
        team = integerInput();

            if(team == 1 || team == 2) {

                if (team == 1) {
                    // printjuniorTeam(); ej implementeret
                }
                if (team == 2) {
                   // printSeniorTeam(); ej implementeret
                }
                System.out.println("Enter ID of chosen swimmer: ");
                memberID = integerInput();
                System.out.println(competitionController.getCompetitionSwimmer(memberID));
                System.out.println("Discipline: ");
                type = stringInput();
                System.out.println("Length in Meters: ");
                distance = integerInput();
                System.out.println("Time: ");
                time = integerInput();
                System.out.println("Year: ");
                year = integerInput();
                System.out.println("Month: ");
                month = integerInput() - 1;
                System.out.println("Day: ");
                day = integerInput();
                date = new Date(year, month, day);
                if(isTournamentResult){
                    System.out.println("Tournament: "); // new added
                    String tournamentName = stringInput();
                    System.out.println("Placement: "); // new added
                    int placement = integerInput();
                    competitionController.addNewTournamentResult(memberID, new TournamentResult(time, date, new SwimDiscipline(distance, type), placement, tournamentName)); // new added
                } else
                competitionController.addNewTrainingResult(memberID, new TrainingResult(time, date, new SwimDiscipline(distance, type))); // new added
                System.out.println("Result is now saved");
            }
    }
    public void findTeamText(){
        System.out.println("Choose a team: ");
        System.out.println("[1] Junior Team");
        System.out.println("[2] Senior Team");
        System.out.println("[3] Back to Menu");
    }

    /**
     * Printer CompetitionSwimmers
     */
    public void printCompetitionSwimmers(){ //TODO lave en metode der returnere en liste over CompetitionSwimmers;
        printCompetitionList(competitionController.listOfCompetitionSwimmers());
    }

    /**
     * printer JuniorTeam
     */
    public void printJuniorTeam(){
        printCompetitionList(competitionController.juniorTeamList());
    }

    /**
     * printer seniorTeam
     */
    public void printSeniorTeam(){
        printCompetitionList(competitionController.seniorTeamList());
    }

    public void printTopFive(){
        System.out.println("Discipline:");
        String discipline = stringInput();
        printCompetitionList(competitionController.topFiveMembers(discipline));
    }
    //#endregion

    //#region Members Menu
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
     * showMembersMenu Switch
     */
    public void showMembersMenu() throws InputMismatchException{
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;

        showMembersText();

            while(running){
                try{
                switch (menuChoice.nextInt()) {

                    case 1: // viser member details på ønsket medlem
                        printMemberDetails();
                        break;
                    case 2: //Edit member
                        editMember();
                        break;
                    case 3: //viser liste med active members
                        printListOfActiveMembers();
                        break;
                    case 4: // viser liste med de passive members
                        printListOfPassiveMembers();
                        break;
                    case 5: // Back to mainMenu
                        running = false;
                        break;
                }

            }catch (InputMismatchException e){
                    System.out.println("Wrong input");
            }

        }
    }
    public void printMemberDetails(){ //TODO lave en metode der returnere et member objekt ud fra ID -> getMember(memberID)
        System.out.println("Member ID: ");

        int memberID = integerInput();
        // ID - Name - date of birth - gender
        String name = memberController.getMember(memberID).getName();
        String dateOfBirth = memberController.getMember(memberID).getDateOfBirth();
        String gender = memberController.getMember(memberID).getGender();
        Boolean isActiveMember = memberController.getMember(memberID).isActiveMember();
        int phone = memberController.getMember(memberID).getPhone();
        String email = memberController.getMember(memberID).getEmail();
        String adress = memberController.getMember(memberID).getAdress();

        System.out.println(memberController.getMember(memberID));//printer members toString();
        System.out.println("Active member: " + isActiveMember + "| Phone: " + phone + "Email: " + email + "\n" +
                "Address: " + adress);
    }
    public void editMember() throws InputMismatchException {
        boolean running = true;
        int id = getMemberID();
        Scanner menuChoice = new Scanner(System.in);
        memberController.getMember(id);
        editMemberText();

        while (running) {
            switch (menuChoice.nextInt()) {
                case 1:
                    editMemberName(id);
                    break;
                case 2:
                    editMemberBirthOfDate(id);
                    break;
                case 3:
                    editMemberGender(id);
                    break;
                case 4:
                    editMemberActivityStatus(id);
                    break;
                case 5:
                    editMemberPhone(id);
                    break;
                case 6:
                    editMemberEmail(id);
                    break;
                case 7:
                    editMemberAddress(id);
                    break;
                case 8:
                    running = false;
                    break;
            }
        }
    }
    public void editMemberText(){
        System.out.println("Choose the information you want to change");
        System.out.println("[1] Name");
        System.out.println("[2] Date of birth");
        System.out.println("[3] Gender");
        System.out.println("[4] Activity status");
        System.out.println("[5] Phone number");
        System.out.println("[6] Email");
        System.out.println("[7] Adress");
        System.out.println("[8] Cancel and return to menu");
    }
    public void editMemberName(int id){
        System.out.println("New name: ");
        String name = stringInput();
        memberController.editMemberName(id, name);
        System.out.println("Edited to: ");
        System.out.println(memberController.getMember(id).getName());
    }

    public void editMemberBirthOfDate(int id){
        System.out.println("New Date Of Birth (YY/MM/DD): ");
        String dateOfBirth = stringInput();
        memberController.editMemberDateOfBirth(id,dateOfBirth);
        System.out.println("Edited to: ");
        System.out.println(memberController.getMember(id).getDateOfBirth());
    }
    public void editMemberGender(int id){
        System.out.println("Gender Change: ");
        String gender = stringInput();
        memberController.editMemberGender(id,gender);
        System.out.println("Edited to: ");
        System.out.println(memberController.getMember(id).getGender());
    }

    public void editMemberActivityStatus(int id){
        boolean memberStatus = memberController.getMember(id).isActiveMember();
        memberController.editMemberIsActiveMember(id,!memberStatus);
        if(memberStatus){
            System.out.println("Member now has a Passive Membership");
        } else {
            System.out.println("Member now has a Active Membership");
        }
    }
    public void editMemberPhone(int id){
        System.out.println("New phone number: ");
        int phoneNumber = integerInput();
        memberController.editMemberPhone(id,phoneNumber);
        System.out.println("Edited to: ");
        memberController.getMember(id).getPhone();
    }

    public void editMemberEmail(int id){
        System.out.println("new email: ");
        String email = stringInput();
        memberController.editMemberEmail(id,email);
        System.out.println("New Email: ");
        memberController.getMember(id).getEmail();
    }

    public void editMemberAddress(int id){
        System.out.println("New address: ");
        String address = stringInput();
        memberController.editMemberAdress(id, address);
        System.out.println("new Address: ");
        memberController.getMember(id).getAdress();
    }


    public void printListOfActiveMembers(){ //TODO lave en metode der returner en liste over active medlemmer;
        printMemberList(memberController.activeMemberList());
    }
    public void printListOfPassiveMembers(){ //TODO lave en metode der returner en liste over Passive medlemmer;
        printMemberList(memberController.passiveMemberList());
    }

    //#endregion

    //#region Printer Methods
    public void printMemberList(Collection<Member> list){
        Member[] array = new Member[list.size()];
        list.toArray(array);
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public void printCompetitionList(Collection<Member> list){ // new erstattet CS med Member
        Member[] array = new Member[list.size()];
        list.toArray(array);
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
}
    //#endregion

    //#region Scanner methods
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
    public double doubleInput() throws InputMismatchException {
        Scanner userDouble = new Scanner(System.in);
        double choice;

        if (userDouble.hasNextDouble()) {
            choice = userDouble.nextDouble();
        } else {
            throw new InputMismatchException(); // exception "Input Out of Bounds"
        }

        return choice;
    }
    public String stringInput() throws InputMismatchException {
        Scanner userString = new Scanner(System.in);
        return userString.nextLine();
    }
    //#endregion

    //#region universal Methods
    public int getMemberID(){
        System.out.println("Member ID: ");
        int memberID = integerInput();
        return memberID;
    }
    //#endregion
}
