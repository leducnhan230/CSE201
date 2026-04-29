package Lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EIUONCE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        byte testCases = sc.nextByte();
        while (testCases-- > 0) { 
            Map<Integer, Integer> onceOccur = new HashMap<>();

            int length = sc.nextInt();
            for (int i = 0; i < length; i++) {
                int input = sc.nextInt();
                onceOccur.put(input, onceOccur.getOrDefault(input, 0) + 1);
            }

            List<Integer> keys = new ArrayList<>(onceOccur.keySet());
            Collections.sort(keys);

            for (Integer k : keys) {
                if (onceOccur.get(k) == 1) {
                    sb.append(k).append(" ");
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
        sc.close();
    }
}
