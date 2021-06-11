import java.util.Stack;

public class EqualStrings {

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for(char ch:s1){
            if(ch == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                stack1.push(ch);
            }
        }
        for(char ch:t1){
            if(ch == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else{
                stack2.push(ch);
            }
        }
        s = String.valueOf(stack1);
        System.out.println("s = "+s);
        t = String.valueOf(stack2);
        System.out.println("t = "+t);
        return s.equals(t);
    }

    public static void main(String[] args){
        boolean b =backspaceCompare("a#c","b");
        System.out.println("b = "+b);
    }

}
