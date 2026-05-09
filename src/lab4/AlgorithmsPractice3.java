package lab4;

import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmsPractice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // Input:
        int arrLength = sc.nextInt();
        int functions = sc.nextInt();

        int[] arr = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // ******************Calculation******************

        // Prefix Sum
        long[] PS = new long[arrLength];
        PS[0] = arr[0];
        for (int i = 1; i < PS.length; i++) {
            PS[i] = PS[i - 1] + arr[i];
        }

        // Sort for two TwoPointer
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        while (functions-- > 0) {
            String name = sc.next();

            if (name.equals("SlidingWindow")) {
                int SW = sc.nextInt();
                long max = PS[SW - 1];

                long sum = max;
                for (int i = 1; i <= arr.length - SW; i++) {
                    sum = sum - arr[i - 1] + arr[(SW - 1) + i];
                    if (max < sum)
                        max = sum;
                }
                sb.append(max).append(System.lineSeparator());

            } else if (name.equals("TwoPointer")) {
                long sum = sc.nextLong();

                int first = -1;
                int second = -1;
                int differences = Integer.MAX_VALUE;

                int pt1 = 0;
                int pt2 = arrLength - 1;
                while (pt1 < pt2) {
                    if ((long) sorted[pt1] + sorted[pt2] >= sum) {

                        if (sorted[pt1] + sorted[pt2] == sum) {
                            int tempDifferences = Math.abs(sorted[pt1] - sorted[pt2]);

                            if (differences > tempDifferences) {
                                first = sorted[pt1];
                                second = sorted[pt2];
                                differences = tempDifferences;
                            }
                        }
                        pt2--;

                    } else {
                        pt1++;

                    }
                }
                sb.append(first).append(" ").append(second).append(System.lineSeparator());

            } else {
                int left = sc.nextInt();
                int right = sc.nextInt();

                if (left == 0) {
                    sb.append(PS[right]).append(System.lineSeparator());

                } else {
                    sb.append(PS[right] - PS[left - 1]).append(System.lineSeparator());
                    
                }
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
