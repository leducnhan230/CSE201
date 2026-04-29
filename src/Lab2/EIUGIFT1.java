package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFT1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Gifts = sc.nextInt();
        int piecesOfPaper = sc.nextInt();

        // size of gifts
        int giftSizes[] = new int[Gifts];
        for (int i = 0; i < giftSizes.length; i++) {
            giftSizes[i] = sc.nextInt();
        }
        Arrays.sort(giftSizes);

        // size of pieces of paper
        int paperSizes[] = new int[piecesOfPaper];
        for (int i = 0; i < paperSizes.length; i++) {
            paperSizes[i] = sc.nextInt();
        }
        Arrays.sort(paperSizes);

        // Calculation:
        int giftCount = 0;
        int idx = 0;
        for (int i = 0; i < giftSizes.length; i++) {
            for (int j = idx; j < paperSizes.length; j++) {
                // too small
                if (paperSizes[j] < giftSizes[i] * 2) {
                    continue;
                }

                // fit
                if (giftSizes[i] * 2 <= paperSizes[j] && paperSizes[j] <= giftSizes[i] * 3) {
                    giftCount++;
                    idx = j + 1;
                    break;
                }

                // too big
                if (paperSizes[j] > giftSizes[i] * 3) {
                    break;
                }
            }
        }
        System.out.print(giftCount);
        sc.close();
    }
}
