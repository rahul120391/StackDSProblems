public class StackImplementation<T> {

    Node<T> head = null;

     void push(T data){
        Node<T> node = new Node<>();
        node.data = data;
        node.next = head;
        head = node;
    }

     T pop(){
        if(head==null){
            System.out.println("Stack is empty");
            return null;
        }
        T data = head.data;
        Node<T> next = head.next;
        head.next = null;
        head = next;
        return data;
    }
     T peek(){
        if(head==null){
            System.out.println("Stack is empty");
            return null;
        }
        return head.data;
    }

    void display(){
         Node<T> temp = head;
         while (temp!=null){
             System.out.println(temp.data);
             temp = temp.next;
         }
    }

    void displayFromStart(){
         Node<T> temp = head;
         Node<T> previous = null;
         Node<T> next;
         while (temp!=null){
             next = temp.next;
             temp.next = previous;
             previous = temp;
             temp = next;
         }
         while (previous!=null){
             System.out.println(previous.data);
             previous=previous.next;
         }
         next=null;
    }

    boolean isEmpty(){
         return head==null;
    }

    int getCountOfStack(){
         int count = 0;
         Node<T> temp = head;
         while (temp!=null){
             temp = temp.next;
             count++;
         }
         return count;
    }


}
