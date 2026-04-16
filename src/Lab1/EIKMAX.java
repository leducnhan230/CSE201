package Lab1;

import java.util.Arrays;
import java.util.Scanner;

public class EIKMAX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int length = sc.nextInt();
        int amountNumber = sc.nextInt();
        long[] arr = new long[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        for (int i = 0; i < amountNumber; i++) {
            sb.append(arr[length - 1 - i] + " ");
        }

        System.out.println(sb);
        sc.close();
    }
}
