package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUONCE {
    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();

        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {

            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);

            if (arr[0] != arr[1]) {
                sb.append(arr[0] + " ");
            }

            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j - 1] != arr[j] && arr[j] != arr[j + 1]) {
                    sb.append(arr[j] + " ");
                }
            }

            if (arr[length - 1] != arr[length - 2]) {
                sb.append(arr[length - 1]);
            }

            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
