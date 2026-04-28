package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class EI20213Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        arr[arr.length - 1] = 1_000_000_000;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                sb.append(arr[i]).append(" ").append(1).append(System.lineSeparator());

            } else {
                int count = 0;
                int idx = 0;
                for (int j = i; arr[i] == arr[j]; j++) {
                    count++;
                    idx = j;
                }

                sb.append(arr[i]).append(" ").append(count).append(System.lineSeparator());
                i = idx;
            }
        }
        
        System.out.println(sb);
        sc.close();
    }
}
