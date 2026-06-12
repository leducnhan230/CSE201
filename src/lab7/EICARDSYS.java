package lab7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EICARDSYS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int transactions = sc.nextInt();

        int UNIT = 1_000_000;
        int[] LEVELS = { UNIT, 20 * UNIT, 50 * UNIT, 200 * UNIT, Integer.MAX_VALUE };
        double[] RATES = { 0.02, 0.03, 0.05, 0.07 };

        double totalDiscount = 0;
        Map<String, Customer> customers = new HashMap<>();
        for (int i = 0; i < transactions; i++) {
            String id = sc.next();
            long purchased = sc.nextLong();

            if (customers.containsKey(id)) {
                totalDiscount += customers.get(id).card * purchased;

                Customer customer = customers.get(id);
                customer.setPurchased(purchased);
            } else {
                customers.put(id, new Customer(id, purchased));
            }

            // Update the membership card
            if (customers.get(id).purchased >= LEVELS[LEVELS.length - 1]) {
                customers.get(id).card = RATES[RATES.length - 1];
            } else {
                for (int j = customers.get(id).idx; customers.get(id).purchased >= LEVELS[j]; j++) {
                    customers.get(id).card = RATES[j];
                    customers.get(id).idx = j + 1;
                }
            }
        }
        System.out.println(totalDiscount);
        sc.close();
    }

    static class Customer {
        String id;
        long purchased;
        double card;
        int idx;

        public Customer(String id, long purchased) {
            this.id = id;
            this.purchased = purchased;
            this.card = 0;
            this.idx = 0;
        }

        public void setPurchased(long purchased) {
            this.purchased += purchased;
        }
    }
}
