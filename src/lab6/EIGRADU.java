package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EIGRADU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numStudents = sc.nextInt();
        int minRequired = sc.nextInt();

        List<Student> students = new ArrayList<>();
        while (numStudents-- > 0) {
            long id = sc.nextLong();
            String name = sc.next();
            byte subjects = sc.nextByte();

            Student student = new Student(id, name, subjects);
            for (int i = 0; i < subjects; i++) {
                byte score = sc.nextByte();
                student.addScores(score);
            }

            students.add(student);
        }

        students.sort((n1, n2) -> {
            int cmp = Double.compare(n2.getAvg(), n1.getAvg());
            if (cmp == 0) {
                cmp = Long.compare(n1.id, n2.id);
            }
            return cmp;
        });

        for (Student st : students) {
            if (st.getCredit() >= minRequired) {
                sb.append(st).append(System.lineSeparator());
            }
        }

        System.out.println(sb);
        sc.close();
    }

    static class Student {
        long id;
        String name;
        byte subjects;
        List<Byte> scores;

        public Student(long id, String name, byte subjects) {
            this.id = id;
            this.name = name;
            this.subjects = subjects;
            this.scores = new ArrayList<>();
        }

        public void addScores(byte score) {
            if (score >= 50)
                scores.add(score);
        }

        public double getAvg() {
            int sum = 0;
            for (byte s : scores) {
                sum += s;
            }

            if (sum == 0)
                return 0;
            return sum / scores.size();
        }

        public int getCredit() {
            return scores.size() * 4;
        }

        @Override
        public String toString() {
            return "%s %s %d".formatted(id, name, Math.round(getAvg()));
        }
    }
}
