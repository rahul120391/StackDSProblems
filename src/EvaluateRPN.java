import java.util.Stack;

public class EvaluateRPN {

    static boolean isOperand(String ch){
        return !ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/");
    }
    static int getResult(String operator,int a, int b){
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> -1;
        };
    }

    static int convert(String s){
        int num =0;
        char[] ch = s.toCharArray();
        boolean isNeagtive = false;
        for (char c:ch) {
            if(c == '-'){
                isNeagtive = true;
                continue;
            }
            num = num*10 +c-48;
        }
        return isNeagtive?-num:num;
    }

    static int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (String s: tokens) {
            if(isOperand(s)){
                st.push(s);
            }
            else{
                int b = convert(st.pop());
                int a = convert(st.pop());
                int result = getResult(s,a,b);
                st.push(String.valueOf(result));
            }
        }
        return convert(st.pop());
    }

    public static void main(String[] args){
       String[] s = {"3","-4","+"};
       int result = evalRPN(s);
        System.out.println(result);
    }

}
