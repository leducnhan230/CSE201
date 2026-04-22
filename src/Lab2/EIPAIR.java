package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class EIPAIR {

    public static long countTypes(long n, long[] arr) {
        long count = 0;
        for (long t : arr)
            if (t == n)
                count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCases = sc.nextInt();
        for (long i = 0; i < testCases; i++) {

            // Input:
            int arrLength = sc.nextInt();
            long arr[] = new long[arrLength];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextLong();
            }

            Arrays.sort(arr);

            // Calculation:
            long numberChoices = 0;
            for (int j = 0; j < arr.length - 1; j++) {

                long countTypes = 0;
                if (arr[j] == arr[j + 1]) {
                    countTypes = countTypes(arr[j], arr);
                    j += countTypes - 1;
                }
                numberChoices += countTypes * (countTypes - 1) / 2;
            }
            sb.append(numberChoices).append(System.lineSeparator());
        }
        System.out.println(sb);
        sc.close();
    }
}
