package Lab1;

import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int pageListed = sc.nextInt();
        long arr[] = new long[pageListed + 1];
        for (int i = 0; i < pageListed; i++) {
            arr[i] = sc.nextLong();
        }

        arr[pageListed] = 2_000_000_000;
        Arrays.sort(arr);

        sb.append(arr[0]);
        int count = 0;
        for (int i = 0; i < pageListed; i++) {
            if (arr[i] + 1 == arr[i + 1]) {

                count++;
                if (count >= 2 && i + 1 == pageListed) {
                    sb.append("-").append(arr[pageListed - 1]);
                }

            } else {
                if (count >= 2) {
                    sb.append("-").append(arr[i]);
                } else if (count == 1) {
                    sb.append(" ").append(arr[i]);
                }

                if (i < pageListed - 1) {
                    sb.append(" ");
                }

                if (arr[i + 1] != arr[pageListed]) {
                    sb.append(arr[i + 1]);
                }
                count = 0;
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
