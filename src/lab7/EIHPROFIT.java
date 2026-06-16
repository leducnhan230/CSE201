package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EIHPROFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numProducts = sc.nextInt();
        int numHighest = sc.nextInt();

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            int identity = sc.nextInt();
            String name = sc.next();
            long price = sc.nextLong();
            long cost = sc.nextLong();
            int quantity = sc.nextInt();

            Product product = new Product(identity, name, price, cost, quantity);
            products.add(product);
        }

        products.sort((p1, p2) -> {
            int cmp = Long.compare(p2.getTotalProfit(), p1.getTotalProfit());
            if (cmp == 0) {
                cmp = Integer.compare(p1.identity, p2.identity);
            }
            return cmp;
        });

        long pivot = numHighest < numProducts ? products.get(numHighest - 1).getTotalProfit() : 0;
        for (Product pd : products) {
            if (pd.getTotalProfit() >= pivot) {
                sb.append(pd).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
        sc.close();
    }

    static class Product {
        int identity;
        String name;
        long price;
        long cost;
        int quantity;

        public Product(int identity, String name, long price, long cost, int quantity) {
            this.identity = identity;
            this.name = name;
            this.price = price;
            this.cost = cost;
            this.quantity = quantity;
        }

        public long getTotalProfit() {
            return (price - cost) * quantity;
        }

        @Override
        public String toString() {
            return "%d %s %d".formatted(identity, name, getTotalProfit());
        }
    }
}
