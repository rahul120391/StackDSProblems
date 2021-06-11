import java.util.Stack;

public class PostfixToPrefix {

    static boolean isOperand(char ch){
        if(ch == '+' ||  ch == '-' || ch == '*' || ch == '/'){
            return false;
        }
        return true;
    }

    static String postfixToPrefix(String s){
        Stack<String> st = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(isOperand(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String operand1 = st.pop();
                String operand2 = st.pop();
                String top = ch+operand2+operand1;
                st.push(top);
            }
        }
        return st.peek();
    }

    public static void main(String[] args){
        String s = "ABC/-AK/L-*";
        String infix = postfixToPrefix(s);
        System.out.println("prefix = "+infix);
    }
}
