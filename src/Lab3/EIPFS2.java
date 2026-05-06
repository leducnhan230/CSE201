package Lab3;

import java.util.Scanner;

public class EIPFS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int q = sc.nextInt();

        long numbers[] = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextLong();
        }

        long[] ps = new long[n];
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                ps[i] = numbers[i];
            } else {
                ps[i] = ps[i - 1] + numbers[i];
            }
        }

        for (int i = 0; i < q; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (left == right) {
                sb.append(numbers[left]).append(System.lineSeparator());
            } else {
                if (left == 0) {
                    sb.append(ps[right]).append(System.lineSeparator());
                } else {
                    sb.append(ps[right] - ps[left - 1]).append(System.lineSeparator());
                }
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
