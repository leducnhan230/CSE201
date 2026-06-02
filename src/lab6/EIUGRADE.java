package lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EIUGRADE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int records = sc.nextInt();

        HashMap<Integer, Student> studentList = new HashMap<>();
        for (int i = 0; i < records; i++) {
            int studentID = sc.nextInt();
            int subjectID = sc.nextInt();
            double grade = sc.nextDouble();

            if (!studentList.containsKey(studentID)) {
                studentList.put(studentID, new Student(studentID));
            }

            studentList.get(studentID).addGrade(grade);
        }

        List<Student> avg = new ArrayList<>(studentList.values());
        avg.sort((n1, n2) -> {
            int cmp = Double.compare(n2.avg(), n1.avg());
            if (cmp == 0) {
                return Integer.compare(n1.studentID, n2.studentID);
            }
            return cmp;
        });

        StringBuilder sb = new StringBuilder();
        for (Student sv : avg) {
            sb.append(sv.studentID)
                    .append(" ")
                    .append(sv.avg())
                    .append(System.lineSeparator());
        }

        System.out.println(sb);
        sc.close();
    }

    static class Student {
        int studentID;
        int subjectID;
        double total;
        int countSubjects;

        public Student(int studentID) {
            this.studentID = studentID;
            this.total = 0;
            this.countSubjects = 0;
        }

        public void addGrade(double grade) {
            total += grade;
            countSubjects++;
        }

        public double avg() {
            return total / countSubjects;
        }
    }

}
