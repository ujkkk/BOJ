import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public long run(int N, int [] nums, char [] ops){
        long [] ans = {Integer.MIN_VALUE};
        select(0, 0, nums, ops, N, ans);
        return ans[0];
    }

    private void select(int depth, int sum, int [] nums, char [] ops, int N, long [] ans){
        if(depth >= N){
            ans[0] =  Math.max(ans[0], sum);
            return;
        }

        // 현재 괄호 선택 안함
        select(depth +1, depth==0? nums[depth] : operate(sum, nums[depth], ops[depth-1]),
            nums, ops, N, ans);

        // 현재를 괄호로 선택
        if(depth < N-1){
            int cur = operate(nums[depth], nums[depth+1], ops[depth]);
            select(depth +2, depth==0? cur : operate(sum, cur, ops[depth-1])
                ,nums, ops, N, ans);
        }
    }

    private int operate(int op1, int op2, char op){
        if(op == '+'){
            return op1 + op2;
        }
        else if(op == '-'){
            return op1 - op2;
        }
        else if(op == '*'){
            return op1 * op2;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[(N+1)/2];
        char [] ops = new char[(N+1)/2 -1];

        String [] ntr = br.readLine().split("");
        for(int i=0; i<ntr.length; i++){
            if(i % 2 == 0){
                nums[i/2] = Integer.parseInt(ntr[i]);
            }
            else{
                ops[i/2] = ntr[i].charAt(0);
            }
        }

        System.out.println(new Main().run((N+1)/2, nums, ops));
    }


}

