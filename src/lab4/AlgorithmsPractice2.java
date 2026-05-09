package lab4;

import java.util.Scanner;

public class AlgorithmsPractice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String name = sc.next();
        int arrLength = sc.nextInt();
        int queries = sc.nextInt();

        int arr[] = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        if (name.equals("BinarySearch")) {
            while (queries-- > 0) {
                int target = sc.nextInt();

                int low = 0;
                int high = arrLength - 1;
                int ans = high;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr[mid] >= target) {
                        ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                sb.append(arr[ans] == target ? ans : -1).append(System.lineSeparator());
            }
        } else {
            int PS[] = new int[arrLength];
            PS[0] = arr[0];
            for (int i = 1; i < PS.length; i++) {
                PS[i] = PS[i - 1] + arr[i];
            }
            while (queries-- > 0) {
                int left = sc.nextInt();
                int right = sc.nextInt();

                if (left == 0) {
                    sb.append(PS[right]).append(System.lineSeparator());
                } else {
                    sb.append(PS[right] - PS[left - 1]).append (System.lineSeparator());
                }
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
