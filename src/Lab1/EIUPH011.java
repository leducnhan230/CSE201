package Lab1;

import java.util.Scanner;

public class EIUPH011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int arrLength = sc.nextInt();
        int[] arr = new int[arrLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            boolean flag = true;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = false;
                }
            }

            if (flag) {
                sb.append(arr[i] + " ");
            }
        }
        System.out.print(sb);
        sc.close();
    }
}
