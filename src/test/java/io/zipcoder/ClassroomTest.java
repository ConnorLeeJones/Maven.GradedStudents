package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassroomTest {
    Student thomas;
    Student abraham;
    Student george;
    Student teddy;
    Student franklin;
    Student trump;
    Student added;

    Student null1;
    Student null2;

    Classroom classroom1;

    ArrayList<Student> expectedA = new ArrayList<>();
    ArrayList<Student> expectedB = new ArrayList<>();
    ArrayList<Student> expectedC = new ArrayList<>();
    ArrayList<Student> expectedD = new ArrayList<>();
    ArrayList<Student> expectedF = new ArrayList<>();



    @Before
    public void setUp() {

        Double[] oneExamScores = {10.0, 10.0, 20.0, 20.0, 10.0};
        thomas = new Student("Thomas", "Jefferson", oneExamScores);

        Double[] twoExamScores = {20.0, 10.0, 30.0, 40.0, 40.0};
        abraham = new Student("Abraham", "Lincoln", twoExamScores);

        Double[] threeExamScores = {20.0, 30.0, 40.0, 12.0, 30.0};
        george = new Student("George", "Washington", threeExamScores);

        Double[] fourExamScores = {40.0, 100.0, 100.0, 50.0, 100.0};
        teddy = new Student("Teddy", "Roosevelt", fourExamScores);

        Double[] fiveExamScores = {40.0, 100.0, 100.0, 50.0, 100.0};
        franklin = new Student("Franklin", "Roosevelt", fiveExamScores);

        Double[] sixExamScores = {0.0, 0.0, 0.0, 0.0, 0.0};
        trump = new Student("Donald", "Trump", sixExamScores);

        Double[] addedExamScores = {20.0, 25.5, 45.0, 70.5, 10.0};
        added = new Student("Added", "ToList", addedExamScores);



        Student[] classStudents = {thomas, abraham, george, teddy, franklin, trump};
        classroom1 = new Classroom(classStudents);

    }





    @Test
    public void getStudents() {
        Student[] expected = {thomas, abraham, george, teddy, franklin, trump};
        Student[] actual = classroom1.getStudents();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore() {
        Double expected = 37.4;
        Double actual = classroom1.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudent() {
        Student[] expected = {thomas, abraham, george, teddy, franklin, trump, added};
        classroom1.addStudent(added);

        Student[] actual = classroom1.getStudents();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeStudent() {
        Student[] expected = {thomas, abraham, teddy, franklin, trump};
        classroom1.removeStudent("George", "Washington");
        Student[] actual = classroom1.getStudents();

        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void getStudentsByScore() {
        Student[] expected = {franklin, teddy, abraham, george, thomas, trump};
        classroom1.getStudentsByScore();
        Student[] actual = classroom1.getStudents();

        Assert.assertArrayEquals(expected, actual);

    }


    @Test
    public void getGradeBook() {
        HashMap<String, ArrayList<Student>> actualMap = classroom1.getGradeBook();

        expectedA.add(teddy);
        expectedA.add(franklin);
        expectedB.add(abraham);
        expectedC.add(george);
        expectedD.add(thomas);
        expectedF.add(trump);


        ArrayList<Student> actualA = actualMap.get("A");
        ArrayList<Student> actualB = actualMap.get("B");
        ArrayList<Student> actualC = actualMap.get("C");
        ArrayList<Student> actualD = actualMap.get("D");
        ArrayList<Student> actualF = actualMap.get("F");


        Assert.assertEquals(actualA, expectedA);
        Assert.assertEquals(actualB, expectedB);
        Assert.assertEquals(actualC, expectedC);
        Assert.assertEquals(actualD, expectedD);
        Assert.assertEquals(actualF, expectedF);
    }




/*
    @Test
   public void randomTest() {
        for (Student student : classroom1.students) {
            System.out.println(student.getFirstName() + student.getAverageExamScore());
        }

        System.out.println();
        System.out.println(classroom1.getAverageExamScore());

        classroom1.getStudentsByScore();

        for (Student student : classroom1.students) {
            System.out.println(student.getFirstName() + student.getAverageExamScore());
        }

        System.out.println(classroom1.getGradeBook().toString());


        for (Map.Entry<String, ArrayList<Student>> entry : classroom1.getGradeBook().entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student.getFirstName());
            }
        }

    }
 */


}
