import java.util.Collections;

public class SortStack {

    static StackImplementation<Integer> stack = new StackImplementation<>();
    static void addElementToStack(int data){
        if(stack.isEmpty()){
            stack.push(data);
        }
        else{
            int top = stack.peek();
            if(data<top){
                stack.push(data);
            }
            else{
                stack.pop();
                addElementToStack(data);
                stack.push(top);
            }
        }
    }

    static void sortStack(){
        if(!stack.isEmpty()){
            int top = stack.pop();
            sortStack();
            addElementToStack(top);
        }
    }

    public static void main(String[] args){
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.display();
        sortStack();
        System.out.println("After Sorting");
        stack.display();
    }


}
