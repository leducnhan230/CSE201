package Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EIKMAX {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long length = sc.nextLong();
        int greatestNumbers = sc.nextInt();
        
        List<Long> numberList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            long input = sc.nextLong();
            numberList.add(input);
        }

        numberList.sort((n1, n2) -> {
            return Long.compare(n2, n1);
        });

        for (int i = 0; i < greatestNumbers; i++) {
            sb.append(numberList.get(i)).append(" ");
        }

        System.out.println(sb);
        sc.close();
    }
}
