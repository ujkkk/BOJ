import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int ans;
    public static int [] nums;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ans = 0;

        /* 입력 */
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        int [] dp = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = nums[i];
        }

        /* solution */
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){ // 작은 수 찾기
                    dp[i] = Math.max(dp[i], dp[j]+nums[i]);
                }
            }
        }
        // dp 중 최대값 찾기
        for(int i=0; i<N; i++){
            ans = Math.max(dp[i], ans);
        }

        bw.write(Integer.toString(ans));
        bw.flush();

        bw.close();
        br.close();


    }

}
