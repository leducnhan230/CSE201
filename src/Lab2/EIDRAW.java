package Lab2;

import java.util.Scanner;

public class EIDRAW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int h = sc.nextInt();
        int spaceLeft = 2 * (h - 1);
        int spaceMiddle = 0;
        int spaceRight = 2 * (h - 1);
        for (int i = 0; i < h; i++) {

            // Space left out side
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }

            sb.append("\\");

            // Space left
            for (int j = 0; j < spaceLeft; j++) {
                sb.append(" ");
            }
            spaceLeft -= 2;

            sb.append("/");

            // Space middle
            for (int j = 0; j < spaceMiddle; j++) {
                sb.append(" ");
            }
            spaceMiddle += 2;

            sb.append("\\");

            // Space right
            for (int j = 0; j < spaceRight; j++) {
                sb.append(" ");
            }
            spaceRight -= 2;

            sb.append("/").append(System.lineSeparator());
        }

        System.out.println(sb);
        sc.close();
    }
}
