package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFTS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        long wallet = sc.nextLong();

        int[] itemPrice = new int[items];
        for (int i = 0; i < itemPrice.length; i++) {
            itemPrice[i] = sc.nextInt();
        }

        Arrays.sort(itemPrice);

        int difference = Integer.MAX_VALUE;
        long totalCost = -1;

        int i = 0; // cheapest
        int j = items - 1; // most expensive

        while (i < j) {
            long tempTotal = (long) itemPrice[i] + itemPrice[j];

            if (tempTotal <= wallet) {
                int tempDifference = itemPrice[j] - itemPrice[i];

                if (tempTotal > totalCost) {
                    totalCost = tempTotal;
                    difference = tempDifference;

                } else if (tempTotal == totalCost) {
                    if (tempDifference < difference) {
                        difference = tempDifference;
                    }
                }
                i++;
            } else {
                j--;
            }
        }

        System.out
                .print((totalCost != -1) ? (totalCost + " " + difference) : "-1 -1");
        sc.close();
    }
}
