package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {
    Student connor;

    @Before
    public void setUp() {

        Double[] examScores = {90.5, 100.0, 87.3, 120.5, 90.0};
        connor = new Student("Connor", "Jones", examScores);
    }

    @Test
    public void getFirstName() {
        String expected = "Connor";
        String actual = connor.getFirstName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName() {
        connor.setFirstName("Jonnor");
        String expected = "Jonnor";
        String actual = connor.getFirstName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        String expected = "Jones";
        String actual = connor.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName() {
        connor.setLastName("Cones");
        String expected = "Cones";
        String actual = connor.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScores() {
        String expected = "Exam Scores:\n" +
                "       Exam 1 -> 90\n" +
                "       Exam 2 -> 100\n" +
                "       Exam 3 -> 87\n" +
                "       Exam 4 -> 120\n" +
                "       Exam 5 -> 90";
        String actual = connor.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScore() {
        connor.addExamScore(101.5);
        String expected = "Exam Scores:\n" +
                "       Exam 1 -> 90\n" +
                "       Exam 2 -> 100\n" +
                "       Exam 3 -> 87\n" +
                "       Exam 4 -> 120\n" +
                "       Exam 5 -> 90\n" +
                "       Exam 6 -> 101";
        String actual = connor.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScore() {

        connor.setExamScore(2, 50.5);
        String expected = "Exam Scores:\n" +
                "       Exam 1 -> 90\n" +
                "       Exam 2 -> 50\n" +
                "       Exam 3 -> 87\n" +
                "       Exam 4 -> 120\n" +
                "       Exam 5 -> 90";
        String actual = connor.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore() {
        Integer expected = 97;
        Integer actual = connor.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScores() {
        ArrayList<Double> newScores = new ArrayList<>();
        newScores.add(10.5);
        newScores.add(70.0);
        newScores.add(87.3);
        connor.setExamScores(newScores);

        String expected = "Exam Scores:\n" +
                "       Exam 1 -> 10\n" +
                "       Exam 2 -> 70\n" +
                "       Exam 3 -> 87";

        String actual = connor.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTaken() {
        Integer expected = 5;
        Integer actual = connor.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }



}