import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int ans;

    public static void main(String [] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ans = -1000;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] dp = new int[n];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(i == 0){
                dp[i] = num;
                continue;
            }
            dp[i] = Math.max(dp[i-1] + num, num);
        }

        // dp 중 최대값 찾기
        for(int i=0; i<dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }

        // 출력
        bw.write(Integer.toString(ans));
        bw.flush();

        bw.close();
        br.close();


    }
}
