package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void compareTo() {

        //Arrange

        TournamentResult result1 = new TournamentResult(120,new Date(1,1,1),new SwimDiscipline(100,"Crawl"),3,"DK");
        TournamentResult result2 = new TournamentResult(200,new Date(1,1,1),new SwimDiscipline(100,"Crawl"),3,"DK");

        //Act
        //Result1 har den hurtigste tid på 120 mod result2 200.
        // laveste tid skal ligge højest oppe på listen.
        boolean test1 = (result1.compareTo(result2) == -1);
        boolean test2 = (result2.compareTo(result2) == 0);
        boolean test3 = (result2.compareTo(result1) == 1);

        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);

    }
}