package Lab1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EIUPH011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int length = sc.nextInt();
        Map<Integer, Integer> firstOccur = new LinkedHashMap<>();

        for (int i = 0; i < length; i++) {
            int input = sc.nextInt();
            firstOccur.put(input, 0);
        }

        for (int key : firstOccur.keySet()) {
            sb.append(key).append(" ");
        }
        System.out.println(sb);
        sc.close();
    }
}
