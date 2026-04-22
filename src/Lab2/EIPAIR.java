package Lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EIPAIR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int gifts = sc.nextInt();
            Map<Long, Long> priceMap = new HashMap<>();

            for (int i = 0; i < gifts; i++) {
                long price = sc.nextLong();
                priceMap.put(price, priceMap.getOrDefault(price, 0L) + 1);
            }

            long totalChoices = 0;
            for (long count : priceMap.values()) {
                if (count >= 2) {
                    totalChoices += count * (count - 1) / 2;
                }
            }
            sb.append(totalChoices).append(System.lineSeparator());
        }
        System.out.println(sb);
        sc.close();
    }
}
