package Lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EIUPH011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int length = sc.nextInt();

        Map<Integer, Integer> fistOccur = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int input = sc.nextInt();
            if (fistOccur.get(input) == null) {
                sb.append(input).append(" ");
                fistOccur.put(input, 0);
            }
        }
        System.out.println(sb);
        sc.close();
    }
}

