import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WaiterProblem {

    public static List<Integer> getPrimeNumbers(int size){
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        int num = 3;
        boolean isPrime = true;
        for (int i = 2 ; i <=size ;  )
        {
            for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
            {
                if ( num%j == 0 )
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                primeNumbers.add(num);
                i++;
            }
            isPrime = true;
            num++;
        }
        return primeNumbers;
    }
    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> answers = new ArrayList<>();
        List<Integer> primeNumbers = getPrimeNumbers(number.size());
        System.out.println(primeNumbers);
        Stack<Integer> st = new Stack<>();
        st.addAll(number);
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        for (int i = 0; i <q ; i++) {
            int primeNumber = primeNumbers.get(i);
            A.clear();
            while (!st.isEmpty()){
                int element = st.pop();
                if(element%primeNumber==0){
                    B.push(element);
                }
                else{
                    A.push(element);
                }
            }
            st.addAll(A);
            while (!B.isEmpty()){
                answers.add(B.pop());
            }
        }
        while (!A.isEmpty()){
            answers.add(A.pop());
        }
        while (!B.isEmpty()){
            answers.add(B.pop());
        }
        return answers;
    }

    public static void main(String[] args){
          List<Integer> numbers = new ArrayList<>();
          numbers.add(3);
          numbers.add(3);
          numbers.add(4);
          numbers.add(4);
          numbers.add(9);
          List<Integer> answers = waiter(numbers,2);
          System.out.println(answers);
          double sq = Math.sqrt(5);
          System.out.println(sq);
    }
}
