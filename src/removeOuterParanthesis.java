import java.util.Stack;

public class removeOuterParanthesis {

    public static String removeOuterParentheses(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> st = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int startIndex = 0;
        int endIndex = 0;
        for (char ch:charArray) {
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                builder.append(s, startIndex+1, endIndex);
                startIndex = endIndex+1;
            }
            endIndex++;
        }
        if(builder.length()==0){
            return "";
        }
        return builder.toString();
    }

    public static void main(String[] args){
        String s= "(()())(())(()(()))";
        String newString = removeOuterParentheses(s);
        System.out.println(newString);

    }
}
