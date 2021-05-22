import View.ViewController;
import controller.MemberController;
import model.Member;
import model.MemberList;
import model.SwimmerProfile;

public class Main {

    private static final ViewController VIEW_CONTROLLER = new ViewController();

    public static void main(String[] args) {

        MemberList instance = MemberList.getInstance();

        //TEST

        Member activeCompSwimmer = new Member("testmember1", "222222", "male", true, 22222222, "22@22", "null", instance.getMemberIDCounter(), new SwimmerProfile());
        activeCompSwimmer.setCompetitionSwimmer(true);
        instance.addMember(activeCompSwimmer); // NB placering nødvendig for at tælle getmemberIDcounter op, før næste memberobjekt oprettes (ellers bliver de overskrevet)

        Member activeExerciser = new Member("testmember2", "222222", "male", true, 22222222, "22@22", "null", instance.getMemberIDCounter(), new SwimmerProfile());
        activeExerciser.setCompetitionSwimmer(false);
        instance.addMember(activeExerciser);


        Member inactiveCompSwimmer = new Member("testmember3", "222222", "male", false, 22222222, "22@22", "null", instance.getMemberIDCounter(), new SwimmerProfile());
        inactiveCompSwimmer.setCompetitionSwimmer(true);
        instance.addMember(inactiveCompSwimmer);

        Member inactiveExerciser = new Member("testmember4", "222222", "male", false, 22222222, "22@22", "null", instance.getMemberIDCounter(), new SwimmerProfile());
        inactiveExerciser.setCompetitionSwimmer(false);
        instance.addMember(inactiveExerciser);


        VIEW_CONTROLLER.mainMenu();

    }
}
