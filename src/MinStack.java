import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> auxiliaryStack;
    MinStack(){
        mainStack = new Stack<>();
    }
    public void push(int val) {
       mainStack.push(val);
       if(auxiliaryStack.isEmpty()){
          auxiliaryStack.push(mainStack.peek());
       }
       else{
           if(mainStack.peek()<auxiliaryStack.peek()){
               auxiliaryStack.push(mainStack.peek());
           }
           else{
               auxiliaryStack.push(auxiliaryStack.peek());
           }
       }
    }

    public void pop() {
        mainStack.pop();
        auxiliaryStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return auxiliaryStack.isEmpty()?0:auxiliaryStack.peek();
    }


}
