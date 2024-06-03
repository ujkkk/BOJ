import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());    // 명령의 개수
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            String [] op = br.readLine().split(" ");
            int operation = Integer.parseInt(op[0]);
            if(op.length == 1){
                switch (operation){
                    case 2: // pop
                        if(!stack.empty()){
                            bw.write(stack.pop()+"\n");
                        } else{
                            bw.write(-1+"\n");
                        }
                        break;
                    case 3:
                        bw.write(stack.size()+"\n");
                        break;
                    case 4:
                        if(stack.isEmpty()){
                            bw.write(1 + "\n");
                        } else {
                            bw.write(0 + "\n");
                        }
                        break;
                    case 5:
                        if(!stack.empty()){
                            bw.write(stack.peek()+"\n");
                        } else{
                            bw.write(-1+"\n");
                        }
                        break;
                    }
                }
            // add 연산
            else{
                stack.push(Integer.parseInt(op[1]));
            }
        }
        bw.flush();
    }



}


