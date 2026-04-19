package Lab1;

import java.util.Scanner;

public class EIDORM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int numberRooms = sc.nextInt();
        for (int i = 0; i < numberRooms; i++) {
            int currentPeople = sc.nextInt();
            int maxPeople = sc.nextInt();

            if (currentPeople + 2 <= maxPeople) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
