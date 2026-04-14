package Lab1;

import java.util.Scanner;

public class EIUPH010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] count = new int[1_000_000];
        for (int i = 0; i < length; i++) {
            int input = sc.nextInt();
            count[input]++;
        }

        int maxValue = -1;
        int timeOccurs = -1;
        for (int i = 0; i < count.length; i++) {
            if (timeOccurs < count[i]) {
                maxValue = i;
                timeOccurs = count[i];
            }
        }
        System.out.println(maxValue + " " + timeOccurs);
        sc.close();
    }
}
