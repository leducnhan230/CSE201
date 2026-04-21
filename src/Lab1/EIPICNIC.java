package Lab1;

import java.util.Scanner;

public class EIPICNIC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberGroups = sc.nextInt();
        int[] groups = new int[5];
        for (int i = 0; i < numberGroups; i++) {
            byte input = sc.nextByte();
            groups[input]++;
        }

        int numberCars = 0;

        // group 4:
        numberCars += groups[4];

        // group 3 + group 1:
        int remainingG1 = 0;
        if (groups[3] >= groups[1]) {
            numberCars += groups[1]; // number of cars is calculate by making group 1 and 3 together.
            numberCars += groups[3] - groups[1]; // number of cars for remaining group 3.

        } else {
            numberCars += groups[3];
            remainingG1 = groups[1] - groups[3];
        }

        // group 2:
        numberCars += groups[2] / 2;
        int remainingG2 = groups[2] % 2;

        double temp = (remainingG1 + remainingG2 * 2) / 4.0;
        numberCars += Math.ceil(temp);

        System.out.println(numberCars);
        sc.close();
    }
}
