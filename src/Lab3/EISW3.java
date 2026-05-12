package Lab3;

import java.util.Scanner;

public class EISW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chars = sc.next();

        int WINDOW_SIZE = 3;
        int arrLength = chars.length();

        int check[] = new int[26];
        int distinct = 0;
        int ans = 0;

        if (arrLength < WINDOW_SIZE) {
            System.out.println(0);
        } else {
            for (int i = 0; i < WINDOW_SIZE; i++) {
                int idx = chars.charAt(i) - 'a';
                if (check[idx] == 0) {
                    distinct++;
                }
                check[idx]++;
            }

            if (distinct == WINDOW_SIZE) {
                ans++;
            }

            for (int i = WINDOW_SIZE; i < arrLength; i++) {

                // delete the left char
                int leftIdx = chars.charAt(i - WINDOW_SIZE) - 'a';
                check[leftIdx]--;
                if (check[leftIdx] == 0) {
                    distinct--;
                }
                
                // add a new char
                int rightIdx = chars.charAt(i) - 'a';
                if (check[rightIdx] == 0) {
                    distinct++;
                }
                check[rightIdx]++;

                if (distinct == WINDOW_SIZE) {
                    ans++;
                }
            }

            System.out.println(ans);
            sc.close();
        }

    }
}
