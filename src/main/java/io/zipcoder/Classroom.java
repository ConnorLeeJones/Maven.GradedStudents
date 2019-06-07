package io.zipcoder;

import java.util.*;

public class Classroom {
    Student[] students;


    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom() {
        this.students = new Student[30];
    }




    public Student[] getStudents() {
        return students;
    }

//    public Double getAverageExamScore() {
//        Double sum = 0.0;
//        for (Student student : students){
//            sum += student.getAverageExamScore();
//        }
//        return sum / students.length;
//    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        Integer totalExams = 0;

        for (Student student : students){
            for (Double examScore : student.examScores){
                sum += examScore;
                totalExams++;
            }
        }
        return sum / totalExams;
    }


    public void addStudent(Student student){
        ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(students));
        studentsList.add(student);
        students = studentsList.toArray(students);
    }


    public Student[] removeStudent(String firstName, String lastName){



//        for (Iterator<Student> iterator = studentsList.iterator(); iterator.hasNext(); ) {
//            String studentFirstName = iterator.next().getFirstName();
//            String studentLastName = iterator.next().getLastName();
//
//            if (studentFirstName.equals(firstName) && studentLastName.equals(lastName)) {
//                iterator.remove();
//            }
//        }
        ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(students));

        Iterator<Student> iterator = studentsList.iterator();
        while (iterator.hasNext()) {
            Student nextStudent = iterator.next();


            String studentFirstName = nextStudent.getFirstName();
            String studentLastName = nextStudent.getLastName();

            if (studentFirstName.equals(firstName) && studentLastName.equals(lastName)) {
                iterator.remove();
            }
        }

        students = new Student[studentsList.size()];
        students = studentsList.toArray(students);
        return students;
    }



    public void getStudentsByScore() {
        ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(students));

        Collections.sort(studentsList, new Student.studentSorter());
        students = studentsList.toArray(students);
        //return  students;
    }



    public HashMap< String, ArrayList<Student>> getGradeBook() {

        HashMap<String, ArrayList<Student>> studentMap = new HashMap<>();

        ArrayList<Student> gradeA = new ArrayList<>();
        ArrayList<Student> gradeB = new ArrayList<>();
        ArrayList<Student> gradeC = new ArrayList<>();
        ArrayList<Student> gradeD = new ArrayList<>();
        ArrayList<Student> gradeF = new ArrayList<>();

        studentMap.put("A", gradeA);
        studentMap.put("B", gradeB);
        studentMap.put("C", gradeC);
        studentMap.put("D", gradeD);
        studentMap.put("F", gradeF);

        for (Student student : students)
            if (student.getAverageExamScore() >= getAverageExamScore()*0.9){
                gradeA.add(student);
            } else if (student.getAverageExamScore() > getAverageExamScore()*0.7) {
                gradeB.add(student);
            } else if (student.getAverageExamScore() >= getAverageExamScore()*0.5) {
                gradeC.add(student);
            } else if (student.getAverageExamScore() > getAverageExamScore()*0.1) {
                gradeD.add(student);
            } else {
                gradeF.add(student);
        }
        return studentMap;
    }

}
