package Lab3;

import java.util.Scanner;

public class EIPFS3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] pS = new int[length];
        pS[0] = arr[0];
        for (int i = 1; i < pS.length; i++) {
            pS[i] = pS[i - 1] + arr[i];
        }

        if (pS[0] == pS[length - 1]) {
            System.out.println(0);
        } else {
            int index = -1;
            for (int i = 1; i < pS.length; i++) {
                if (pS[i - 1] == (pS[length - 1] - pS[i])) {
                    index = i;
                }
            }
            System.out.println(index);
        }

        sc.close();
    }
}
