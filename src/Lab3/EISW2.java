package Lab3;

import java.util.Scanner;

public class EISW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int sW = sc.nextInt();

        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        long total = 0;
        for (int i = 0; i < sW; i++) {
            total += arr[i];
        }
        double avg = total / (double) sW;

        for (int i = 1; i < arr.length - sW + 1; i++) {
            total = total - arr[i - 1] + arr[sW - 1 + i];

            double temp = total / (double) sW;
            if (avg < temp) {
                avg = temp;
            }
        }
        System.out.print(Math.round(avg * 100) / 100.0);
        sc.close();
    }
}
