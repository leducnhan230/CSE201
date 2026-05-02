package Lab2;

import java.util.Scanner;

public class EIU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        // ****************head*******************//

        sb.append(" ");
        for (int i = 0; i < n / 2; i++) {
            sb.append("_");
        }
        sb.append(System.lineSeparator());

        // *****************body********************//

        // body 1:
        for (int i = 0; i < n / 2; i++) {
            sb.append("|");
            for (int j = 0; j <= n / 2; j++) {
                if (i + 1 != n / 2)
                    sb.append(" ");
            }

            // end of body 1
            if (i + 1 == n / 2) {
                for (int j = 0; j < n / 2; j++) {
                    sb.append("_");
                }
                sb.append(" ");
            }

            sb.append("| |");
            for (int j = 0; j < n / 2; j++) {
                sb.append(" ");
            }
            sb.append("|").append(System.lineSeparator());
        }

        // body 2:
        for (int i = 0; i < n / 2; i++) {
            sb.append("|");
            for (int j = 0; j <= n / 2; j++) {
                if (i + 1 != n / 2)
                    sb.append(" ");
            }

            // End of E
            if (i + 1 == n / 2) {
                for (int j = 0; j < n / 2; j++) {
                    sb.append("_");
                }
                sb.append(" ");
            }

            sb.append("| |");

            // End of U
            if (i + 1 == n / 2) {
                for (int j = 0; j < n / 2; j++) {
                    sb.append("_");
                }

            } else {
                for (int j = 0; j < n / 2; j++) {
                    sb.append(" ");
                }
            }
            sb.append("|").append(System.lineSeparator());
        }
        System.out.println(sb);
        sc.close();
    }
}
