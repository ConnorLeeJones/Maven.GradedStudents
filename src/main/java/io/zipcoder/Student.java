package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

public class Student {
    private String firstName;
    String lastName;
    ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        String scoresString = "Exam Scores:";
        for (Double score : examScores) {
            scoresString += "\n       Exam " + (examScores.indexOf(score) + 1) + " -> " + score.intValue();
        }
        return scoresString;
    }

    public void addExamScore(Double score) {
        examScores.add(score);
    }


    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public Integer getAverageExamScore() {
        Double sum = 0.0;
        for (Double score : examScores) {
            sum += score;
        }
        return (int) (sum / examScores.size());
    }


    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }


    static class studentSorter implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            int scoreCompare = o2.getAverageExamScore().compareTo(o1.getAverageExamScore());
            int lastNameCompare = o1.getLastName().compareTo(o2.getLastName());
            int firstNameCompare = o1.getFirstName().compareTo(o2.getFirstName());

            if (scoreCompare == 0){
                return ((lastNameCompare == 0) ? firstNameCompare : lastNameCompare);
            } else {
                return scoreCompare;
            }
        }
    }



/*
    @Override
    public int compareTo(Student o) {
        if (this.getAverageExamScore() == o.getAverageExamScore()) {
            return compare(getLastName(), o.getLastName());
        } else {
            return this.getAverageExamScore() - o.getAverageExamScore();
        }

    }



    public int compare(Student a, Student b){
        if (a.getAverageExamScore() == b.getAverageExamScore()){
            return a.getAverageExamScore() - b.getAverageExamScore();
        } else {
            return a.getLastName().compareTo(b.getLastName());
        }
    }

 */
}
