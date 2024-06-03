import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        while(true){
            int idx = 0;
            boolean flag = true;
            char [] str = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            while(str[idx] != '.'){
                idx++;
                if(str[idx-1] == '(' || str[idx-1] == '[' ){
                    stack.push(str[idx-1]);
                }
                else if(str[idx-1] == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        flag = false;
                        break;
                    }
                }
                else if(str[idx-1] == ']'){
                    if(stack.isEmpty()||stack.pop() != '['){
                        flag = false;
                        break;
                    }
                }

            }

            if(idx == 0)
                break;
            // 스택에 남아있을 때면 no
            if(stack.size() != 0){
                flag = false;
            }
            if(flag)
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        bw.flush();
    }



}


