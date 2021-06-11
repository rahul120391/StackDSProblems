import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix{

    static boolean isOperand(char ch){
        return ch != '+' && ch != '-' && ch != '*' && ch != '/';
    }

    static int checkPrecedence(char ch){
        if(ch == '+' ||  ch == '-' ){
            return 1;
        }
        else if(ch == '*' || ch == '/'){
            return 2;
        }
        return 0;
    }

    static String infixToPostFix(String s){
        char[] postfix = new char[s.length()];
        Stack<Character> st = new Stack<>();
        int i = 0;
        for (int k = 0; k <s.length() ; k++) {
             char ch = s.charAt(k);
             if(isOperand(ch)){
                 postfix[i++] = ch;
             }
             else{
                 if(st.isEmpty()){
                     st.push(ch);
                     continue;
                 }
                 while (!st.isEmpty() && checkPrecedence(ch) <= checkPrecedence(st.peek())) {
                     char top = st.pop();
                     postfix[i++] = top;
                 }
                 st.push(ch);
             }
        }
        while (!st.isEmpty()){
            postfix[i++] = st.pop();
        }


        return String.valueOf(postfix);
    }



    public static void main(String[] args){
        Scanner scanner;
        try{
            File f = new File("C:\\Users\\rkumar\\DsAndAlgo\\Stacks\\resources\\files\\CalculatorInput");
            scanner = new Scanner(f);
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNext()){
                builder.append(scanner.next());
            }
            long time1 = System.currentTimeMillis();
            System.out.println("time 1 = "+time1);
            String result = infixToPostFix(builder.toString());
            long time2 = System.currentTimeMillis();
            System.out.println("time 2 = "+time2);
            System.out.println("Difference = "+(time2-time1));
            System.out.println("result = "+result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
