import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwoStackProblem {


    static Stack<Integer> getStack(List<Integer> numbers){
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.size()-1; i >=0 ; i--) {
            stack.push(numbers.get(i));
        }
        return stack;
    }

    static Stack<Integer> calculateStackElements(Stack<Integer> stack, int maxSum){
        Stack<Integer> s = new Stack<>();
        int sumKeep=0;
        while (!stack.isEmpty() && sumKeep+stack.peek()<=maxSum) {
            int top = stack.pop();
            sumKeep = sumKeep+top;
            s.add(top);
        }
        Collections.reverse(s);
        stack.addAll(s);
        return s;
    }
    static List<Integer> subList = new ArrayList<>();
    static int[] getNumberOfElements(Stack<Integer> stack,int maxSum,int sumKeep,int previousSum){
        subList.clear();
        sumKeep += previousSum;
        while (!stack.isEmpty() && sumKeep+stack.peek()<=maxSum){
            int top = stack.pop();
            sumKeep = sumKeep+top;
            subList.add(top);
        }
        if(!subList.isEmpty()){
            int sum = 0;
            for (int item:subList) {
                sum += item;
            }
            previousSum += sum;
        }
        return new int[]{subList.size(),previousSum};
    }


    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        Stack<Integer> s1 = getStack(a);
        Stack<Integer> s2 = getStack(b);
        Stack<Integer> stack1 = calculateStackElements(s1,maxSum);
        Stack<Integer> stack2 = calculateStackElements(s2,maxSum);
        int max = Math.max(stack1.size(),stack2.size());
        int sum = stack1.stream().mapToInt(Integer::intValue).sum();
        Collections.reverse(stack1);
        int previousSum = 0;
        int previousCount = 0;
        while (!stack1.isEmpty()){
            int[] data = getNumberOfElements(s2,maxSum,sum,previousSum);
            int numberOfElements = data[0]+previousCount;
            previousSum = data[1];
            int size = numberOfElements + stack1.size();
            previousCount= numberOfElements;
            if(size>max){
                max=size;
            }
            int top  = stack1.pop();
            sum -= top;
        }
        return max;
    }


    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("C:\\Users\\rkumar\\DsAndAlgo\\Stacks\\resources\\files\\ArrayA"));
            while (scanner.hasNext()){
                String contents = scanner.nextLine();
                String[] value = contents.split(" ");
                for (String s:value){
                    list1.add(Integer.parseInt(s));
                }
            }
            scanner = new Scanner(new File("C:\\Users\\rkumar\\DsAndAlgo\\Stacks\\resources\\files\\ArrayB"));
            while (scanner.hasNext()){
                String contents = scanner.nextLine();
                String[] value = contents.split(" ");
                for (String s:value){
                    list2.add(Integer.parseInt(s));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int maxElements = twoStacks(1000000000,list1,list2);
        System.out.println("max elements = "+maxElements);
    }

}
