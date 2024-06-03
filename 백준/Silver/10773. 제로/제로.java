import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        int K = Integer.parseInt(br.readLine());    // 명령의 개수
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                stack.pop();
            } else{
                stack.push(cur);
            }
        }

        long sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        bw.write(sum+"\n");
        bw.flush();
    }



}


