package controller;
//@Author Lærke

import model.admin.Member;
import model.admin.MemberList;
import model.coach.SwimDiscipline;
import model.coach.TrainingResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class CompetitionControllerTest {

    @org.junit.jupiter.api.Test
    void topFiveMembers() {

        // Arrange
        int testPhoneNumber = 22222222;
        String testEmail = "some email";
        String testAddress = "some address";
        MemberController memberController = new MemberController();

        // activeCompMember(s)
        memberController.addMember("compMember1", 10, "male", true, testPhoneNumber, testEmail, testAddress, true);
        memberController.addMember("compMember2", 20, "male", true, testPhoneNumber, testEmail, testAddress, true);
        memberController.addMember("compMember3", 30, "male", true, testPhoneNumber, testEmail, testAddress, true);
        memberController.addMember("compMember4", 40, "male", true, testPhoneNumber, testEmail, testAddress, true);
        memberController.addMember("compMember5", 50, "male", true, testPhoneNumber, testEmail, testAddress, true);
        memberController.addMember("compMember6", 60, "male", true, testPhoneNumber, testEmail, testAddress, true);

        // activeExerciser(s)
        memberController.addMember("exerciser1", 10, "male", true, testPhoneNumber, testEmail, testAddress, false);

        CompetitionController competitionController = new CompetitionController();
        competitionController.addNewTrainingResult(1, new TrainingResult(1000, new Date(), new SwimDiscipline(300, "crawl")));
        competitionController.addNewTrainingResult(1, new TrainingResult(500, new Date(), new SwimDiscipline(300, "crawl")));
        competitionController.addNewTrainingResult(2, new TrainingResult(400, new Date(), new SwimDiscipline(300, "crawl")));
        competitionController.addNewTrainingResult(3, new TrainingResult(450, new Date(), new SwimDiscipline(300, "crawl")));
        competitionController.addNewTrainingResult(4, new TrainingResult(300, new Date(), new SwimDiscipline(300, "crawl")));
        competitionController.addNewTrainingResult(5, new TrainingResult(750, new Date(), new SwimDiscipline(300, "crawl")));
        competitionController.addNewTrainingResult(6, new TrainingResult(600, new Date(), new SwimDiscipline(300, "crawl")));

        // Act
        Collection<Member> actualMembers = competitionController.topFiveMembers("crawl");

        // Assert
        assertEquals(5, actualMembers.size());
        Member[] expectedMembers = new Member[] {
            MemberList.getInstance().getMember(4),
            MemberList.getInstance().getMember(2),
            MemberList.getInstance().getMember(3),
            MemberList.getInstance().getMember(1),
            MemberList.getInstance().getMember(6)
        };
        assertIterableEquals(Arrays.asList(expectedMembers), actualMembers);
    }
}