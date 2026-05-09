package lab4;

import java.util.Scanner;

public class AlgorithmsPractice1 {
    public static Scanner sc = new Scanner(System.in);
    public static StringBuilder sb = new StringBuilder();

    // Binary Search
    public static int BinarySearch(int[] arr) {
        int target = sc.nextInt();

        int low = 0, high = arr.length - 1, ans = -1;
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
        return ans;
    }

    // Sliding Window
    public static long SlidingWindow(int[] arr) {
        int windowSize = sc.nextInt();

        long min = Long.MAX_VALUE;
        long temp = 0;
        for (int i = 0; i <= arr.length - windowSize; i++) {
            if (i == 0) {
                for (int j = 0; j < windowSize; j++) {
                    temp += arr[j];
                }

                if (temp < min)
                    min = temp;

            } else {
                temp = temp - arr[i - 1] + arr[(windowSize - 1) + i];
                if (temp < min)
                    min = temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String name = sc.next();
        int length = sc.nextInt();
        int queries = sc.nextInt();

        // Array input:
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        if (name.equals("BinarySearch"))
            while (queries-- > 0)
                sb.append(BinarySearch(arr)).append(System.lineSeparator());
        else
            while (queries-- > 0)
                sb.append(SlidingWindow(arr)).append(System.lineSeparator());
        System.out.println(sb);
        sc.close();
    }
}
