package View;

import controller.CompetitionController;
import controller.MemberController;
import controller.SaveLoadController;
import model.admin.Member;
import model.coach.Result;
import model.coach.SwimDiscipline;
import model.coach.TournamentResult;
import model.coach.TrainingResult;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
//@author Mark Kaplan Hansen
//@author Mads Rasmussen
public class ViewController {

    private final CompetitionController competitionController = new CompetitionController();
    private final MemberController memberController = new MemberController();
    private final SaveLoadController saveLoadController = new SaveLoadController();
    //#region MainMenu

    /**
     * Main menu UI
     */
    public void mainMenuText(){

        System.out.println("[1] Show members"); //TODO lave en liste der kan printes i MemberController som indeholder Navn, Alder og Exerciser/Comp Swimmer
        System.out.println("[2] Add new member");
        System.out.println("[3] Coach options");
        System.out.println("[4] Exit program" );
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    /**
     * Main menu Switch
     */
    public void mainMenu() throws InputMismatchException, FileNotFoundException {
        saveLoadController.loadMemberList();
        Scanner menuChoice = new Scanner(System.in);
        boolean running = true;
        while(running) {
            saveLoadController.saveMemberList();
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
        System.out.println("[1] Exerciser");
        System.out.println("[2] Competition Swimmer");
        System.out.println("[3] Back to Main Menu");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    public void addMember() throws FileNotFoundException {
        newMemberMenuText();
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
        System.out.println("Enter Age: ");
        int age = integerInput();
        System.out.println("Enter Gender");
        String gender = stringInput();
        Boolean active = true;
        System.out.println("Enter phone number");
        int phonenumber = integerInput();
        System.out.println("Enter email address");
        String Email =  stringInput();
        System.out.println("Enter Address");
        String address = stringInput();
        memberController.addMember(name, age, gender, active, phonenumber, Email, address, isCompetitionSwimmer); // new
        saveLoadController.saveMemberList();
    }

    public void deleteMember() throws FileNotFoundException {
        System.out.println("Enter the ID of the member to be removed");
        int memberToBeRemoved = integerInput();
        System.out.println(memberController.getMember(memberToBeRemoved) + " has been removed");
        memberController.memberToRemove(memberToBeRemoved);
        saveLoadController.saveMemberList();
        System.out.println("-------------------------------------------");
        System.out.println();

    }

    public void printListOfMembers() {
        printMemberList(memberController.getMemberList());
        System.out.println("-------------------------------------------");
        System.out.println();
    }
    //#endregion

    //#region Coach Menu
    /**
     * Coach option under menu
     */
    public void coachMenuText(){
        System.out.println("[1] Show Competition Swimmers");
        System.out.println("[2] Show Competition Swimmer result");
        System.out.println("[3] Add new Training result");
        System.out.println("[4] Add new Competition result");
        System.out.println("[5] Top 5 Swimmers in Discipline");
        System.out.println("[6] Back to Main Menu");
        System.out.println("-------------------------------------------");
        System.out.println();
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
                    showResults();
                case 3:
                    addNewResult(false);
                    break;
                case 4:
                    addNewResult(true);
                    break;
                case 5:
                    printTopFive();
                    break;
                case 6:
                    running = false;
                    break;
            }
        }
    }

    public void showResults(){
        System.out.println("Enter memberID: ");
        int memberID = integerInput();
       printResultList(competitionController.getCompetitionSwimmer(memberID).getSwimmerprofile().listOfResults());
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
                    printJuniorTeam();
                }
                if (team == 2) {
                   printSeniorTeam();
                }
                System.out.println("Enter ID of chosen swimmer: ");
                memberID = integerInput();
                System.out.println(competitionController.getCompetitionSwimmer(memberID));
                System.out.println("Discipline: ");
                type = stringInput();
                System.out.println("Length in Meters: ");
                distance = integerInput();
                System.out.println("Time in seconds: ");
                time = integerInput();
                System.out.println("Year: ");
                year = integerInput();
                System.out.println("Month: ");
                month = integerInput() - 1;
                System.out.println("Day: ");
                day = integerInput();
                date = new Date(year, month, day);
                if(isTournamentResult){
                    System.out.println("Tournament: ");
                    String tournamentName = stringInput();
                    System.out.println("Placement: ");
                    int placement = integerInput();
                    competitionController.addNewTournamentResult(memberID, new TournamentResult(time, date, new SwimDiscipline(distance, type), placement, tournamentName));
                } else
                competitionController.addNewTrainingResult(memberID, new TrainingResult(time, date, new SwimDiscipline(distance, type)));
                System.out.println("Result is now saved");
            }
    }
    public void findTeamText(){
        System.out.println("Choose a team: ");
        System.out.println("[1] Junior Team");
        System.out.println("[2] Senior Team");
        System.out.println("[3] Back to Menu");
        System.out.println("-------------------------------------------");
        System.out.println();
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
        System.out.println("Discipline: ");
        String discipline = stringInput();
        printCompetitionList(competitionController.topFiveMembers(discipline));
    }

    //#endregion

    //#region Members Menu
    /**
     * show members under menu
     */
    public void showMembersText(){
        System.out.println("[1] Show member details");
        System.out.println("[2] Edit member");
        System.out.println("[3] Remove member");
        System.out.println("[4] Show Active members");
        System.out.println("[5] Show Passive members");
        System.out.println("[6] Back to Main Menu");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    /**
     * showMembersMenu Switch
     */
    public void showMembersMenu() throws InputMismatchException, FileNotFoundException {

        boolean running = true;

            while(running){
                try{
                    showMembersText();
                switch (integerInput()) {

                    case 1: // viser member details på ønsket medlem
                        printMemberDetails();
                        break;
                    case 2: //Edit member
                        editMember();
                        break;
                    case 3:
                        printListOfMembers();
                        deleteMember();
                        break;
                    case 4: //viser liste med active members
                        printListOfActiveMembers();
                        break;
                    case 5: // viser liste med de passive members
                        printListOfPassiveMembers();
                        break;
                    case 6: // Back to mainMenu
                        running = false;
                        break;
                }

            }catch (InputMismatchException e){
                    System.out.println("Wrong input");
            }

        }
    }
    public void printMemberDetails(){
        System.out.println("Member ID: ");

        int memberID = integerInput();
        // ID - Name - date of birth - gender
        Boolean isActiveMember = memberController.getMember(memberID).isActiveMember();
        int phone = memberController.getMember(memberID).getPhone();
        String email = memberController.getMember(memberID).getEmail();
        String adress = memberController.getMember(memberID).getAdress();

        System.out.println(memberController.getMember(memberID));//printer members toString();
        System.out.println("Active member: " + isActiveMember + "| Phone: " + phone + " Email: " + email + "\n" +
                "Address: " + adress);
        System.out.println("-------------------------------------------");
        System.out.println();
    }
    public void editMember() throws InputMismatchException {
        boolean running = true;
        int id = getMemberID();
        memberController.getMember(id);

        while (running) {
            System.out.println(memberController.getMember(id));
            System.out.println();
            editMemberText();
            switch (integerInput()) {
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
        System.out.println("[2] Age");
        System.out.println("[3] Gender");
        System.out.println("[4] Activity status");
        System.out.println("[5] Phone number");
        System.out.println("[6] Email");
        System.out.println("[7] Address");
        System.out.println("[8] Return to menu");
        System.out.println("-------------------------------------------");
        System.out.println();
    }
    public void editMemberName(int id){
        System.out.println("New name: ");
        String name = stringInput();
        memberController.editMemberName(id, name);
        System.out.println("Edited to: ");
        System.out.println(memberController.getMember(id).getName());
    }

    public void editMemberBirthOfDate(int id){
        System.out.println("Age: ");
        int age = integerInput();
        memberController.editMemberDateOfBirth(id,age);
        System.out.println("Edited to: ");
        System.out.println(memberController.getMember(id).getAge());
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
        System.out.println(memberController.getMember(id).getPhone());
    }

    public void editMemberEmail(int id){
        System.out.println("New email: ");
        String email = stringInput();
        memberController.editMemberEmail(id,email);
        System.out.println("New Email: ");
        System.out.println(memberController.getMember(id).getEmail());
    }

    public void editMemberAddress(int id){
        System.out.println("New address: ");
        String address = stringInput();
        memberController.editMemberAdress(id, address);
        System.out.println("New Address: ");
        System.out.println(memberController.getMember(id).getAdress());
    }


    public void printListOfActiveMembers(){ //TODO lave en metode der returner en liste over active medlemmer;
        printMemberList(memberController.activeMemberList());
    }
    public void printListOfPassiveMembers(){ //TODO lave en metode der returner en liste over Passive medlemmer;
        printMemberList(memberController.passiveMemberList());
    }

    //#endregion



    //#region Printer Methods

    public void printResultList(Collection<Result> list){
        Result[] array = new Result[list.size()];

        list.toArray(array);
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }

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
