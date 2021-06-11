import java.io.File;
import java.util.*;

public class BasicCalculator {

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

    static int getResult(String operator,int a, int b){
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> -1;
        };
    }

    public static int calculate(String s) {
        Stack<String> st = new Stack<>();
        char[] newString = s.trim().toCharArray();
        List<String> data = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char ch:newString) {
            if(!isOperand(ch)){
                data.add(builder.toString());
                builder.delete(0,builder.length());
                if(st.isEmpty()){
                    st.push(String.valueOf(ch));
                    continue;
                }
                while (!st.isEmpty() && checkPrecedence(ch) <= checkPrecedence(st.peek().charAt(0))) {
                    String top = st.pop();
                    data.add(top);
                }
                st.push(String.valueOf(ch));
                continue;
            }
            builder.append(ch);
        }
        data.add(builder.toString());
        while (!st.isEmpty()){
            data.add(st.pop());
        }
        Stack<Integer> number = new Stack<>();
        for (String value:data) {
            if(value.contains("-") || value.contains("*") || value.contains("+") || value.contains("/")){
                int b = number.pop();
                int a = number.pop();
                int result = getResult(value,a,b);
                number.push(result);
            }
            else {
                number.push(Integer.valueOf(value));
            }
        }
        return number.isEmpty()?0:number.pop();
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
            int result = calculate(builder.toString());
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
