import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][] rgbs = new int[N+1][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgbs[i][0] = Integer.parseInt(st.nextToken());
            rgbs[i][1] = Integer.parseInt(st.nextToken());
            rgbs[i][2] = Integer.parseInt(st.nextToken());

        }

        long dp[][] = new long[N+1][3];
        dp[1][0] = rgbs[1][0];
        dp[1][1] = rgbs[1][1];
        dp[1][2] = rgbs[1][2];

        for(int i=2; i<=N; i++){
            dp[i][0] =Math.min(dp[i-1][1], dp[i -1][2]) + rgbs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i -1][2]) + rgbs[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i -1][0])+ rgbs[i][2];
        }

        long min = Long.MAX_VALUE;
        for(long value : dp[N]){
            min = Math.min(min, value);
        }
        bw.write(min+"\n");
        bw.flush();
    }
}
