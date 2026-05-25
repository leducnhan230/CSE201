package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EISLS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numStudents = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int j = 0; j < numStudents; j++) {
            String name = sc.next();
            int subjects = sc.nextInt();

            Student student = new Student(name, subjects);
            for (int i = 0; i < subjects; i++) {
                byte score = sc.nextByte();
                student.setSum(score);
            }
            students.add(student);
        }

        students.sort((s1, s2) -> {
            return Double.compare(s2.getAvg(), s1.getAvg());
        });

        for (int i = 0; i < (2 < numStudents ? 2 : numStudents); i++) {
            sb.append(students.get(i)).append(System.lineSeparator());
        }

        System.out.println(sb);
        sc.close();
    }

    static class Student {
        String name;
        int subjects;
        double sum;

        public Student(String name, int subjects) {
            this.name = name;
            this.subjects = subjects;
        }

        public void setSum(byte score) {
            sum += score;
        }

        public double getAvg() {
            return sum / subjects;
        }

        @Override
        public String toString() {
            return "%s".formatted(name);
        }
    }
}
