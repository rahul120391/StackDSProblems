import java.util.Stack;

public class BaseBallGame {

    public static int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String op:ops){
            switch(op){
                case "+":
                    int top = st.pop();
                    int sum = top+st.peek();
                    st.push(top);
                    st.push(sum);
                    break;
                case "C":
                    st.pop();
                    break;
                case "D":
                    st.push(st.peek()*2);
                    break;
                default:
                    st.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        while (!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }

    public static void main(String[] args){
        String[] s = {"5","2","C","D","+"};
        int sum = calPoints(s);
        System.out.println("sum is = "+sum);
    }
}
