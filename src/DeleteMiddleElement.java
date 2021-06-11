public class DeleteMiddleElement {

    static StackImplementation<Integer> stack = new StackImplementation<>();

    static void deleteMiddle(int count){
        if(count==0){
            return;
        }
        else{
            int top = stack.pop();
            deleteMiddle(count-1);
            if(count>1){
                stack.push(top);
            }
        }
    }

    static void deleteMiddleElement(){
         int count = stack.getCountOfStack();
         int middle=0;
         if (count%2==0){
             middle = count/2;
         }
         else{
             middle = count/2+1;
         }
         deleteMiddle(middle);
    }


    public static void main(String args[]){
        for (int i = 1; i <=4 ; i++) {
            stack.push(i);
        }
        stack.display();
        deleteMiddleElement();
        System.out.println("after delete");
        stack.display();
    }

}
