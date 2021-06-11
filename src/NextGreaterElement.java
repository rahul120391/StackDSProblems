import java.util.Stack;

public class NextGreaterElement {

    static Stack<Integer> getStack(int[] num){
        Stack<Integer> Stack = new Stack<>();
        for (int i = num.length-1; i>=0; i--) {
            Stack.push(num[i]);
        }
        return Stack;
    }

     static int getMaxElement(Stack<Integer> s2,int maxElement,int top){
        if(s2.isEmpty()){
            return maxElement;
        }
         int peek = s2.peek();
         if(peek>top){
             return peek;
         }
         int pop = s2.pop();
         int element = getMaxElement(s2,maxElement,top);
         if(element>maxElement){
             s2.push(pop);
             return element;
         }
         s2.push(pop);
        return maxElement;
     }

     static void findNextGreaterElement(int element,Stack<Integer> s2,int[] result,int count,boolean istrue){
        if(s2.isEmpty()){
            return;
        }
        int top = s2.pop();
        if(top == element){
            result[count] = -1;
            if(!s2.isEmpty()){
                if(s2.peek()>element){
                    result[count] = s2.peek();
                }
                else{
                    findNextGreaterElement(element,s2,result,count,!istrue);
                }
            }
        }
        else{
            if(top>element && !istrue){
                result[count]= top;
                s2.push(top);
                return;
            }
            findNextGreaterElement(element, s2, result, count,istrue);
        }
         s2.push(top);
     }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
         Stack<Integer> s1 = getStack(nums1);
         Stack<Integer> s2 = getStack(nums2);
         int[] result = new int[nums1.length];
         int count = 0;
         while (!s1.isEmpty()){
               int top = s1.pop();
               findNextGreaterElement(top,s2,result,count,true);
               count++;
         }
         return result;
    }
    public static void main(String[] args){
        int[] num1 = {137,59,92,122,52,131,79,236,94,171,141,86,169,199,248,120,196,168,77,71,5,198,215,230,176,87,189,206,115,76,13,216,197,26,183,54,250,27,109,140,147,25,96,105,30,207,241,8,217,40,0,35,221,191,83,132,9,144,12,91,175,65,170,149,174,82,102,167,62,70,44,143,10,153,160,142,188,81,146,212,15,162,103,163,123,48,245,116,192,14,211,126,63,180,88,155,224,148,134,158,119,165,130,112,166,93,125,1,11,208,150,100,106,194,124,2,184,75,113,104,18,210,202,111,84,223,173,238,41,33,154,47,244,232,249,60,164,227,253,56,157,99,179,6,203,110,127,152,252,55,185,73,67,219,22,156,118,234,37,193,90,187,181,23,220,72,255,58,204,7,107,239,42,139,159,95,45,242,145,172,209,121,24,21,218,246,49,46,243,178,64,161,117,20,214,17,114,69,182,85,229,32,129,29,226,136,39,36,233,43,240,254,57,251,78,51,195,98,205,108,61,66,16,213,19,68,237,190,3,200,133,80,177,97,74,138,38,235,135,186,89,201,4,101,151,31,228,231,34,225,28,222,128,53,50,247};
        int[] num2 = {137,59,92,122,52,131,79,236,94,171,141,86,169,199,248,120,196,168,77,71,5,198,215,230,176,87,189,206,115,76,13,216,197,26,183,54,250,27,109,140,147,25,96,105,30,207,241,8,217,40,0,35,221,191,83,132,9,144,12,91,175,65,170,149,174,82,102,167,62,70,44,143,10,153,160,142,188,81,146,212,15,162,103,163,123,48,245,116,192,14,211,126,63,180,88,155,224,148,134,158,119,165,130,112,166,93,125,1,11,208,150,100,106,194,124,2,184,75,113,104,18,210,202,111,84,223,173,238,41,33,154,47,244,232,249,60,164,227,253,56,157,99,179,6,203,110,127,152,252,55,185,73,67,219,22,156,118,234,37,193,90,187,181,23,220,72,255,58,204,7,107,239,42,139,159,95,45,242,145,172,209,121,24,21,218,246,49,46,243,178,64,161,117,20,214,17,114,69,182,85,229,32,129,29,226,136,39,36,233,43,240,254,57,251,78,51,195,98,205,108,61,66,16,213,19,68,237,190,3,200,133,80,177,97,74,138,38,235,135,186,89,201,4,101,151,31,228,231,34,225,28,222,128,53,50,247};
        //int[] num1 = {3,1,5,7,9,2,6};
        //int[] num2 = {1,2,3,5,6,7,9,11};
        //int[] num1 = {1,3,5,2,4};
        //int[] num2 = {6,5,4,3,2,1,7};
        int[] result = nextGreaterElement(num1,num2);
         for (int i:result) {
            System.out.println(i);
        }
    }
}
