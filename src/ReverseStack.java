public class ReverseStack {

    static StackImplementation<Integer> stack = new StackImplementation<>();
    static void addElementAtBottom(int data){
       if(stack.isEmpty()){
           System.out.println("data is ="+data);
           stack.push(data);
       }
       else{
           int top = stack.pop();
           addElementAtBottom(data);
           stack.push(top);
       }
    }

    static void reverseStack(){
        if(stack.isEmpty()){
            return;
        }
        else{
            int top = stack.pop();
            reverseStack();
            addElementAtBottom(top);
        }
    }

    public static void main(String[] args){
        for (int i = 1; i <=5 ; i++) {
            stack.push(i);
        }
        stack.display();
        reverseStack();
        stack.display();

    }
}
