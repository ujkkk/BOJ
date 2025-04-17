import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for(int n : nums){
            if(max <= n){
                while(max != n){
                    stack.add(++max);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }

            else{
                if (max < n) {
                    System.out.println("NO");
                    return;
                }
                else{
                    do{
                        sb.append("-\n");
                        if(stack.isEmpty()){
                            System.out.println("NO");
                            return;
                        }
                    } while (stack.pop() != n);
                }
            }
        }

        System.out.println(sb);
    }

}