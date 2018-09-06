import java.util.Scanner;
import java.util.Stack;

public class Parantheses {
    public static void main(String []argh)
    {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {

            String s = input.next();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty()) {

                    switch(s.charAt(i)) {
                        case '}' : if (stack.peek() == '{') {
                            stack.pop();
                        }
                            break;
                        case ']' : if (stack.peek() == '[') {
                            stack.pop();
                        }
                            break;
                        case ')' : if (stack.peek() == '(') {
                            stack.pop();
                        }
                            break;
                        default: stack.push(s.charAt(i));
                    }
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
            System.out.println(stack.isEmpty());
        }
    }
}



