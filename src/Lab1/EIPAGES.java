package Lab1;

import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int i = 0;
        while (i < n) {
            int start = arr[i];
            int end = start;

            while (i + 1 < n && arr[i] == arr[i + 1] - 1) {
                i++;
                end = arr[i];
            }

            if (sb.length() > 0)
                sb.append(" ");

            int length = end - start + 1;
            if (length >= 3) {
                sb.append(start).append("-").append(end);
            } else if (length == 2) {
                sb.append(start).append(" ").append(end);
            } else {
                sb.append(start);
            }

            i++;
        }

        System.out.println(sb);
        sc.close();
    }
}
