package Lab1;

import java.util.ArrayList;
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

            long length = sc.nextLong();
            Map<Long, Integer> fistOccur = new HashMap<>();
            for (int i = 0; i < length; i++) {
                long input = sc.nextLong();
                fistOccur.put(input, fistOccur.getOrDefault(input, 0) + 1);
            }

            List<Long> keys = new ArrayList<>(fistOccur.keySet());
            keys.sort((n1, n2) -> {
                return Long.compare(n1, n2);
            });

            for (Long t : keys) {
                if (fistOccur.get(t) == 1)
                    sb.append(t).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
        sc.close();
    }
}
