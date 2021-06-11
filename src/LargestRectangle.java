import java.io.File;
import java.util.*;

public class LargestRectangle {

    static Stack<Integer> getStack(List<Integer> numbers){
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.size()-1; i >=0 ; i--) {
            stack.push(numbers.get(i));
        }
        return stack;
    }

    public static long largestRectangle(List<Integer> h) {
        Stack<Integer> stack = new Stack<>();
        int[] lb = new int[h.size()];
        stack.push(0);
        lb[0] = -1;
        for (int i = 1; i <h.size() ; i++) {
            while (!stack.isEmpty() && h.get(i)<=h.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                lb[i] = -1;
            }
            else{
                lb[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        int[] rb = new int[h.size()];
        stack.push(h.size()-1);
        rb[h.size()-1] = h.size();
        for (int i = h.size()-2; i>=0 ; i--) {
            while (!stack.isEmpty() && h.get(i)<=h.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                rb[i] = h.size();
            }
            else{
                rb[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i <h.size() ; i++) {
            int width = rb[i]-lb[i]-1;
            int area = h.get(i)*width;
            if(area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }




    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("C:\\Users\\rkumar\\DsAndAlgo\\Stacks\\resources\\files\\Input"));
            while (scanner.hasNext()) {
                String contents = scanner.nextLine();
                String[] value = contents.split(" ");
                for (String s : value) {
                    list.add(Integer.parseInt(s));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        long area = largestRectangle(list);
        System.out.println("area = "+area);
    }
}
