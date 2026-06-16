package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EISCHSH {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numStudents = sc.nextInt();
        int rangeScholarship = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int j = 0; j < numStudents; j++) {
            long id = sc.nextLong();
            String name = sc.next();
            int subjects = sc.nextInt();

            Student student = new Student(id, name, subjects);
            for (int i = 0; i < subjects; i++) {
                byte score = sc.nextByte();
                student.addScores(score);
            }

            students.add(student);
        }

        students.sort((s1, s2) -> {
            int cmp = Double.compare(s2.getAvg(), s1.getAvg());
            if (cmp == 0) {
                cmp = Long.compare(s1.id, s2.id);
            }
            return cmp;
        });

        int currentRank = 0;
        int numAwarded = 0;
        for (int i = 0; currentRank <= rangeScholarship && i < students.size(); i++) {
            numAwarded++;
            if (i == 0) {
                currentRank++;
                sb.append(currentRank).append(" ").append(students.get(i)).append(System.lineSeparator());
            } else {
                if (students.get(i).getAvg() == students.get(i - 1).getAvg()) {
                    sb.append(currentRank).append(" ").append(students.get(i)).append(System.lineSeparator());
                } else {
                    currentRank = numAwarded;
                    if (currentRank > rangeScholarship)
                        break;
                    sb.append(numAwarded).append(" ").append(students.get(i)).append(System.lineSeparator());
                }
            }
        }
        System.out.print(sb);
        sc.close();
    }

    static class Student {
        long id;
        String name;
        int subjects;
        long sum;

        public Student(long id, String name, int subjects) {
            this.id = id;
            this.name = name;
            this.subjects = subjects;
            this.sum = 0;
        }

        public void addScores(byte score) {
            if (score >= 50) {
                sum += score;
            } else {
                subjects--;
            }

        }

        public double getAvg() {
            if (subjects == 0)
                return 0;
            return (double) sum / subjects;
        }

        @Override
        public String toString() {
            return "%d %s %d".formatted(id, name, Math.round(getAvg()));
        }

    }

}
