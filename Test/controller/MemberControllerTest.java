package controller;

import model.MemberList;
import model.Member;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/* @Author Simon Roswall Jørgensen
    Tests af noget af MemberControlleren
 */

class MemberControllerTest {
    MemberList memberList = MemberList.getInstance();
    MemberController memberController = new MemberController();
    boolean testDataInitialized = false;

    void initializeTestData(){
        if (!testDataInitialized){
            memberList.addMember(new Member(memberList.getMemberIDCounter(),"test1", 18, "male", true, 11223344, "a@b.c", "addres", false));
            memberList.addMember(new Member(memberList.getMemberIDCounter(),"test2", 18, "male", false, 11223344, "a@b.c", "addres", false));
            memberList.addMember(new Member(memberList.getMemberIDCounter(),"test3", 18, "male", true, 11223344, "a@b.c", "addres", false));
            memberList.addMember(new Member(memberList.getMemberIDCounter(),"test4", 18, "male", false, 11223344, "a@b.c", "addres", false));
            testDataInitialized = true;
        }
    }


    @Test
    void getMemberList(){
        // Arrange
        // Populating the list with testmembers
        initializeTestData();

        // Act
        // Running a test
        Collection<Member> result = memberController.getMemberList();

        //Assert

        assertSame(memberList.getMemberList(), result);
    }

    @Test
    void activeMemberList() {
        // Arrange
        // Populating the list with testmembers
        initializeTestData();

        // Act
        // Running a test
        List<Member> Result = (ArrayList<Member>) memberController.activeMemberList();
        
        int test1 = Result.size();
        boolean test2 = Result.get(0).isActiveMember();
        boolean test3 = Result.get(1).isActiveMember();

        // Assert

        assertEquals(2,test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    @Test
    void passiveMemberList() {
        // Arrange
        // Populating the list with testmembers
        initializeTestData();

        MemberController memberController = new MemberController();

        // Act
        // Running a test
        List<Member> Result = (ArrayList<Member>) memberController.passiveMemberList();

        int test1 = Result.size();
        boolean test2 = Result.get(0).isActiveMember();
        boolean test3 = Result.get(1).isActiveMember();

        // Assert

        assertEquals(2,test1);
        assertFalse(test2);
        assertFalse(test3);
    }
}