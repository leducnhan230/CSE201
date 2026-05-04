package Lab3;

import java.util.Scanner;

public class EIPFS1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int ps[] = new int[n];
        for (int i = 0; i < ps.length; i++) {
            if (i == 0) {
                ps[i] = numbers[i];
            } else {
                ps[i] = ps[i - 1] + numbers[i];
            }
        }

        for (int t : ps) {
            sb.append(t).append(" ");
        }
        System.out.println(sb);
        sc.close();
    }
}
