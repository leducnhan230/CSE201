package Lab3;

import java.util.Arrays;
import java.util.Scanner;

public class EISW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int sW = sc.nextInt();

        int arr[] = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int difference = 0;
        if (length == 1) {
            System.out.println(difference);
        } else {
            difference = 1_000_000;

            for (int i = 0; i < arr.length - sW + 1; i++) {
                int temp = Math.abs(arr[i] - arr[i + sW - 1]);
                if (temp < difference) {
                    difference = temp;
                }
            }
            System.out.println(difference);
        }

        sc.close();
    }
}
