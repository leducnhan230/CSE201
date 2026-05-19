package lab5;

import java.util.Scanner;

public class EISWMED1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String B = sc.next();
        int k = sc.nextInt();

        int min = 0;
        for (int i = 0; i < k; i++) {
            if (B.charAt(i) == 'W')
                min++;
        }

        int operation = min;
        for (int i = 1; i <= B.length() - k; i++) {

            if (B.charAt(i - 1) == 'W')
                operation--;

            if (B.charAt((k - 1) + i) == 'W')
                operation++;

            if (min > operation)
                min = operation;

        }

        System.out.println(min);
        sc.close();
    }
}
