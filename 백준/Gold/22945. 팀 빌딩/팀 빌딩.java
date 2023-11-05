import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static int N;
    static int [] nums;

    public static void main(String [] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // input
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;
        int result = 0;
        int min = 0;


        while(start < end){
            min = Math.min(nums[start], nums[end]);
            result = Math.max(result, min*(end-start-1));

            // 작은 것을 이동시켜야 더 높은 값을 얻을 수 있다
            if(nums[start]<nums[end]){
                start++;
            }
            else{
                end--;
            }
        }

        System.out.println(result);
    }
}
