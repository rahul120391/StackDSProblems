import java.util.Stack;

public class BalancedParenthesis {


    public static boolean checkBalancedParenthesis(String value){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <value.length() ; i++) {
            char ch = value.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            switch (ch){
                case '}':{
                    if(stack.peek() == '[' || stack.peek() == '('){
                        return false;
                    }
                    stack.pop();
                    break;
                }
                case ']':{
                    if(stack.peek() == '{' || stack.peek() == '('){
                        return false;
                    }
                    stack.pop();
                    break;
                }
                case ')':{
                    if(stack.peek() == '{' || stack.peek() == '['){
                        return false;
                    }
                    stack.pop();
                    break;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args){
        boolean check = checkBalancedParenthesis("{]");
        if(check){
            System.out.println("yes its balanced");
        }else{
            System.out.println("its not balanced");
        }
    }
}
