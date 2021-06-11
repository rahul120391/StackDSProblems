import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    static int convert(String s){
        int num =0;
        char[] ch = s.toCharArray();
        for (char c:ch) {
            num = num*10 +c-48;
        }
        return num;
    }
    static Stack<String> oper = new Stack<>();
    static String s = "";
    static void textEditor(String op){
        char ch = op.charAt(0);
        switch (ch){
                case '1':{
                    String value = op.substring(2);
                    s = s+value;
                    oper.push(s);
                    break;
                }
                case '2':{
                    int k = s.length() - convert(op.substring(2));
                    s = s.substring(0,k);
                    oper.push(s);
                    break;
                }
                case '3':{
                    int k = convert(op.substring(2));
                    System.out.println(s.charAt(k-1));
                    break;
                }
                default:{
                    s = "";
                    oper.pop();
                    if(!oper.empty()){
                        s = oper.peek();
                    }
                }
            }
    }

    public static void main(String[] args){
        Scanner scanner;
        int i = 0;
        try {
            scanner = new Scanner(new File("C:\\Users\\rkumar\\DsAndAlgo\\Stacks\\resources\\files\\textEditorInput"));
            while (scanner.hasNext()) {
                textEditor(scanner.nextLine());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
