package Lab1;

import java.util.Scanner;

public class EIPICNIC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[5];
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            arr[input]++;
        }

        arr[1] = Math.max(0, arr[1] - (arr[3] + (arr[2] % 2) * 2));

        long total = arr[4] + arr[3] + arr[2] / 2 + arr[2] % 2 + (long) Math.ceil(arr[1] / 4.0);

        System.out.println(total);
        sc.close();
    }
}
