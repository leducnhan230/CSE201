package Lab1;

import java.util.Scanner;

public class EIUPH014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        while (n != 0) {
            // input:
            long[] numbers = new long[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextLong();
            }

            boolean flag = true;
            int iterations = 0;
            for (int i = 0; i < 1000; i++) {

                // Check each iteration
                for (int j = 0; j < numbers.length - 1; j++) {
                    if (numbers[j] != numbers[j + 1]) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if (flag)
                    break;

                long temp = numbers[0];
                for (int j = 0; j < n - 1; j++) {
                    numbers[j] = Math.abs(numbers[j] - numbers[j + 1]);
                }
                // Final element:
                numbers[n - 1] = Math.abs(numbers[n - 1] - temp);
                iterations++;
            }

            if (flag) {
                sb.append(iterations).append(System.lineSeparator());
            } else {
                sb.append(-1).append(System.lineSeparator());
            }

            n = sc.nextInt();
        }

        System.out.println(sb);
        sc.close();
    }
}
