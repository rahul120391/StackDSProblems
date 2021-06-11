
import java.util.ListIterator;
import java.util.Stack;

public class removeDuplicates {


    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ch:charArray) {
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            if(st.peek() == ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        charArray = new char[st.size()];
        ListIterator<Character> itr = st.listIterator();
        int i = 0;
        while (itr.hasNext()){
            charArray[i++] = itr.next();
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args){
       String string = removeDuplicates("abbaca");
       System.out.println(string);
    }
}
