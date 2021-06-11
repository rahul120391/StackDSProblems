import java.util.Stack;

public class minOperations {

    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String s:logs) {
            if (s.equals("../")){
               if(!stack.isEmpty()){
                   stack.pop();
               }
            }
            else if(s.equals("./")){
                continue;
            }
            else{
                stack.push(s);
            }
        }
        return stack.size();
    }

    public static void main(String[] args){
        String[] s = {"d1/","../","../","../"};
        int a = minOperations(s);
        System.out.println(a);
    }
}
