package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EICREDIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberStudents = sc.nextInt();

        List<Student> studentList = new ArrayList<>();
        while (numberStudents-- > 0) {
            String name = sc.next();
            int numberSubjects = sc.nextInt();

            Student student = new Student(name);
            for (int i = 0; i < numberSubjects; i++) {
                int grade = sc.nextInt();
                student.addGrade(grade);
            }

            studentList.add(student);
        }

        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append(student.name)
                    .append(" ")
                    .append(student.creditHour)
                    .append(System.lineSeparator());
        }

        System.out.println(sb);
        sc.close();
    }

    static class Student {
        String name;
        int creditHour;

        public Student(String name) {
            this.name = name;
            this.creditHour = 0;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                creditHour += 4;
            }
        }
    }
}
