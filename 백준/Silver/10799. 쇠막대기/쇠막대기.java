import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        int lazer = 0;
        int cur = 0;

        String str = (br.readLine());
        // 스택 완성
        for(int i=0; i< str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push(-1);
            }
            if (str.charAt(i) == ')'){
                if(stack.peek() == -1){
                    stack.pop();
                    stack.push(1);
                }
                else{
                    lazer = 0;
                    while(!((cur = stack.pop()) == -1)){
                        if(cur >= 1){
                            lazer += cur;
                        }
                    }
                    sum += lazer +1;
                    stack.push(lazer);
                }
            }
        }


        System.out.println(sum);


    }





}
