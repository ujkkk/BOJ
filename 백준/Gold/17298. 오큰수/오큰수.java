import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int [] NGE = new int[N];
        for(int i=N-1; i>=0; i--){
            if(stack.isEmpty()){
                stack.add(nums[i]);
                NGE[i] = -1;
                continue;
            }

            while(true){
                // 본인보다 큰게 없음
                if(stack.isEmpty()){
                    NGE[i] = -1;
                    break;
                }
                // 본인보다 큰 거 찾음
                if(stack.peek() > nums[i]){
                    NGE[i] = stack.peek();
                    break;

                }
                // 작은 것 다 빼기, 어차피 현재 요소가 우선순위가 되니 필요없음
                stack.pop();
            }

            stack.add(nums[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int nge: NGE){
            sb.append(nge).append(" ");
        }
        System.out.println(sb);

    }

}