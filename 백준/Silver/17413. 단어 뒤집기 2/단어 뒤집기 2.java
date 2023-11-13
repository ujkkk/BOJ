
import java.io.*;
import java.util.*;


class Main
{
    public static HashSet<Character> set;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String data = br.readLine();
        int idx = 0;
        Stack<Character> stack = new Stack<>();
        while(idx < data.length()){
           if(data.charAt(idx) == '<') {
               while (data.charAt(idx) != '>') {
                   bw.write(data.charAt(idx));
                   idx++;
               }
               bw.write(data.charAt(idx));
               idx++;
               continue;
           }

            while(data.charAt(idx) != ' ' && data.charAt(idx) != '<'){
                stack.push(data.charAt(idx));
                idx++;
                if(idx == data.length())
                    break;
            }

            while (!stack.isEmpty()){
                bw.write(stack.pop());
            }

            if(idx == data.length())
                break;

            if(data.charAt(idx) == '<')
                continue;

            bw.write(data.charAt(idx));
            idx++;
        }

        bw.flush();

        bw.close();
        br.close();

    }

}

