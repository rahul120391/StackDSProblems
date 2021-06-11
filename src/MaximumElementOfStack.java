import java.util.*;

public class MaximumElementOfStack{

    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> data = new ArrayList<>();
        int maximumElement = -1;
        String previousOperation = "";
        for (String s:operations) {
            if(s.length()<=1){
                if(s.equals("2") && !stack.isEmpty()){
                    stack.pop();
                }
                else if(s.equals("3") && !stack.isEmpty()){
                    if(previousOperation.equals(s) && maximumElement!=-1){
                        data.add(maximumElement);
                        continue;
                    }
                    maximumElement = Collections.max(new ArrayList<>(stack));
                    data.add(maximumElement);
                }
            }
            else{
                stack.push(Integer.parseInt(s.substring(2)));
            }
            previousOperation = s;
        }
        return data;
    }



    public static void main(String[] args){
          List<String> operations = new ArrayList<>();
          int count = 1;
          for (int i = 1; i <=100000 ; i++) {
               if(i%2==0){
                   operations.add("3");
               }
               else{
                   operations.add(1+" "+count);
                   count++;
               }
          }
        long startTime = System.nanoTime();
        List<Integer> list = getMax(operations);
        long elapsedTime = System.nanoTime()-startTime;
        System.out.println("execution time in milliseconds = "+elapsedTime);
        System.out.println("execution time in seconds = "+elapsedTime/1000);
        System.out.println("list = "+list);

    }
}
