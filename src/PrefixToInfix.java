import java.util.Stack;

public class PrefixToInfix {
    static boolean isOperand(char ch){
        if(ch == '+' ||  ch == '-' || ch == '*' || ch == '/'){
            return false;
        }
        return true;
    }

    static String prefixToInfix(String s){
        Stack<String> st = new Stack<>();
        for (int i = s.length()-1; i >=0 ; i--) {
            char ch = s.charAt(i);
            if(isOperand(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String top = "("+st.pop()+ch+st.pop()+")";
                st.push(top);
            }
        }
        return st.peek();
    }

    public static void main(String[] args){
         String s = "*-A/BC-/AKL";
         String infix = prefixToInfix(s);
         System.out.println("infix = "+infix);
    }
}
