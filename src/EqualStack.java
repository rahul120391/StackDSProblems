import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EqualStack {

    static Stack<Integer> getStack(List<Integer> numbers){
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.size()-1; i >=0 ; i--) {
            stack.push(numbers.get(i));
        }
        return stack;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
         Stack<Integer> stack1 = getStack(h1);
         Stack<Integer> stack2 = getStack(h2);
         Stack<Integer> stack3 = getStack(h3);
         int stack1Sum = stack1.stream().mapToInt(Integer::intValue).sum();
         int stack2Sum = stack2.stream().mapToInt(Integer::intValue).sum();
         int stack3Sum = stack3.stream().mapToInt(Integer::intValue).sum();
         while (true){
             if(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()){
                 return 0;
             }
             if(stack1Sum == stack2Sum && stack1Sum == stack3Sum){
                 return stack1Sum;
             }
             if(stack1Sum>=stack2Sum && stack1Sum>=stack3Sum){
                 int top = stack1.pop();
                 stack1Sum = stack1Sum-top;
             }
             else if(stack2Sum>=stack1Sum && stack2Sum>=stack3Sum){
                 int top = stack2.pop();
                 stack2Sum = stack2Sum-top;
             }
             else{
                 int top = stack3.pop();
                 stack3Sum = stack3Sum-top;
             }
         }
    }


    public static void main(String[] args){
         int[] A = {3, 2, 1, 1, 1};
         int[] B = {4,3,2};
         int[] C = {1,1,4,1};
         List<Integer> listA  = new ArrayList<>();
         for (int item:A) {
             listA.add(item);
         }
         List<Integer> listB = new ArrayList<>();
         for (int item:B) {
            listB.add(item);
         }
         List<Integer> listC = new ArrayList<>();
        for (int item:C) {
            listC.add(item);
        }
        int maxEqualSum = equalStacks(listA,listB,listC);
        System.out.println(maxEqualSum);
    }

}
