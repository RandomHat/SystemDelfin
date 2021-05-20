package View;

import controller.CompetitionController;
import controller.MemberController;
import model.CompetitionSwimmer;
import model.Member;

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
            mainMenu();
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
        memberController.addMember(name, birthday, gender, active, phonenumber, Email, address);
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
                    break;
                case 2:
                    addNewResult(false);
                    break;
                case 3:
                    addNewResult(true);

            }
        }
    }

    public void addNewResult(boolean isTournamentResult) {
        int team;
        int memberID;
        double time;
        int distance;
        String type;
        Date date;
        int year, month, day;

        findTeamText();
        team = integerInput();

            if(team == 1 || team == 2) {

                if (team == 1) {
                    printjuniorTeam();
                }
                if (team == 2) {
                    printSeniorTeam();
                }
                System.out.println("Enter ID of chosen swimmer: ");
                memberID = integerInput();
                System.out.println(competitionController.getMember(memberID));
                System.out.println("Discipline: ");
                type = stringInput();
                System.out.println("Length: ");
                distance = integerInput();
                System.out.println("Time: ");
                time = doubleInput();
                System.out.println("Date: ");
                System.out.println("Year: ");
                year = integerInput();
                System.out.println("Month: ");
                month = integerInput() - 1;
                System.out.println("Day: ");
                day = integerInput();
                date = new Date(year, month, day);
                if(isTournamentResult){
                    String tournamentName = stringInput();
                    int placement = integerInput();
                    competitionController.addNewResult(memberID, time, date, distance, type, tournamentName,placement);
                } else
                competitionController.addNewResult(memberID, time, date, distance, type);
                System.out.println("Result is now saved");
            }
    }

    public void findTeamText(){
        System.out.println("Choose a team: ");
        System.out.println("[1] Junior Team");
        System.out.println("[2] Senior Team");
        System.out.println("[3] Back to Menu");
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
        Boolean isActiveMember = memberController.getMember(memberID).getIsActiveMember();
        int phone = memberController.getMember(memberID).getPhone();
        String email = memberController.getMember(memberID).getEmail();
        String adress = memberController.getMember(memberID).getAdress();

        System.out.println(memberController.getMember(memberID))//printer members toString();
        System.out.println("Active member: " + isActiveMember + "| Phone: " + phone + "Email: " + email + "\n" +
                "Adress: " + adress);
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
    //#endregion

    //#region Memberlist Printers
    public void printMemberList(Collection<Member> list){
        Member[] array = new Member[list.size()];
        list.toArray(array);
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public void printListOfActiveMembers(){ //TODO lave en metode der returner en liste over active medlemmer;
        printMemberList(memberController.activeMemberList());
    }
    public void printListOfPassiveMembers(){ //TODO lave en metode der returner en liste over Passive medlemmer;
        printMemberList(memberController.passiveMemberList());
    }
    public void printListOfMembers() { // TODO lave en metode der returnere en liste over alle medlemmer;
        printMemberList(memberController.memberList());
    }
    //#endregion

    //#region Competition Array Printers
    public void printCompetitionList(Collection<CompetitionSwimmer> list){
    CompetitionSwimmer[] array = new CompetitionSwimmer[list.size()];
    list.toArray(array);
    for (int i = 0; i<array.length;i++){
        System.out.println(array[i]);
    }
}
    public void printCompetitionSwimmers(){ //TODO lave en metode der returnere en liste over CompetitionSwimmers;
            printCompetitionList(competitionController.competitionSwimmers());
        }
    public void printjuniorTeam(){
        printCompetitionList(competitionController.juniorTeam());
    }
    public void printSeniorTeam(){
        printCompetitionList(competitionController.seniorTeam());
    }
    //#endregion

    //#region Scanner
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
}
