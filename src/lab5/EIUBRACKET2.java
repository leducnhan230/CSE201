    package lab5;

    import java.util.Scanner;
    import java.util.Stack;

    public class EIUBRACKET2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();

            byte testCases = sc.nextByte();
            while (testCases-- > 0) {
                String input = sc.next();
                sb.append(isValid(input)).append(System.lineSeparator());
            }
            System.out.println(sb);
            sc.close();
        }

        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty())
                        return false;

                    char top = stack.pop();
                    if (c == '}' & top != '{')
                        return false;
                    if (c == ']' & top != '[')
                        return false;
                    if (c == ')' & top != '(')
                        return false;   
                }
            }
            return stack.isEmpty();
        }
    }
