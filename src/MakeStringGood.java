import java.util.*;

public class MakeStringGood {

    public static String makeGood(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i =0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(builder.length()==0){
                builder.append(ch);
                continue;
            }
            if(Math.abs((int)ch-(int)(builder.charAt(builder.length()-1)))==32){
                 builder.deleteCharAt(builder.length()-1);
            }
            else{
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
         String s = "leEeetcode";
         System.out.println(makeGood(s));
    }
}
