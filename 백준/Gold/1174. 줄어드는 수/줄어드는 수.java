import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        count++;
        if(N==1){
            System.out.println("0");
            return;
        }

        for(int depth = 1; depth<= 12; depth++){
            if(decreaseNums(0, depth, 9, new int[depth])){
                return;
            }
            if(count >= 500000){
                break;
            }
        }
        System.out.println("-1");
    }


    private static boolean decreaseNums(int depth, int maxDepth, int maxN, int [] nums){
        if(depth == maxDepth){
            count++;

            if(count == N){
                printNums(nums);
                return true;
            }
            return false;
        }

        for(int i=0; i<=maxN; i++){
            if(depth ==0 && i==0)
                continue;

            nums[depth] = i;
            if(decreaseNums(depth+1, maxDepth, i-1, nums)){
                return true;
            }
        }
        return false;
    }

    private static void printNums(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int n: nums){
            sb.append(n);
        }
        System.out.println(sb.toString());
    }
}
