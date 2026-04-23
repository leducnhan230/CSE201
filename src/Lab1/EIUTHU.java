package Lab1;

import java.util.Scanner;

public class EIUTHU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstPart = sc.next();
        String secondPart = sc.next();

        int i = 1;
        int similarChar = 0;
        while (i <= secondPart.length() && i <= firstPart.length()) {
            if (firstPart.substring(firstPart.length() - i, firstPart.length()).equals(secondPart.substring(0, i))) {
                similarChar = i;
            }
            i++;
        }

        System.out.println(firstPart.length() + secondPart.length() - similarChar);
        sc.close();
    }
}
