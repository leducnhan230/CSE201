package lab4;

import java.util.Scanner;

public class AlgorithmsPractice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String name = sc.next();
        int arrLength = sc.nextInt();
        int queries = sc.nextInt();

        int[] arr = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] PS = new int[arrLength];
        PS[0] = arr[0];
        for (int i = 1; i < PS.length; i++) {
            PS[i] = PS[i - 1] + arr[i];
        }

        while (queries-- > 0) {
            if (name.equals("BinarySearch")) {
                int target = sc.nextInt();

                int low = 0, high = arrLength - 1, ans = -1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr[mid] >= target) {
                        if (arr[mid] == target)
                            ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                sb.append(ans).append(System.lineSeparator());
            
            } else {
                int subArray = sc.nextInt();

                // Sliding Window
                long min = PS[subArray - 1];

                long minSum = min;
                for (int i = 1; i <= arr.length - subArray; i++) {
                    min = min - arr[i - 1] + arr[(subArray - 1) + i];
                    if (min < minSum) {
                        minSum = min;
                    }
                }
                sb.append(minSum).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
