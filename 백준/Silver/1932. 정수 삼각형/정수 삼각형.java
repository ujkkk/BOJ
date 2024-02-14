
import java.io.*;

/*
    문제를 작은 문제들로 나눠 풀 수 있음 -> dp 이용
    점화식 : d[N][i] = Math.max(d[N-1][i], Math.Max(d[N-1][i-1], d[N-1][i+1])) + A[N][i]
 */
import java.util.*;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;


    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][] A = new int[N][];
        int [][] dp = new int[N][];

        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = new int[N+1];
            dp[i] = new int[N+1];
            for(int j=0; j<i+1; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = A[0][0];

        for(int i=0; i<N-1; i++){
            for(int j=0; j<i+1; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + A[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + A[i+1][j+1]);
            }
        }
        int result = dp[N-1][0];
        for(int i=1; i<dp[N-1].length; i++){
            result = Math.max(result, dp[N-1][i]);
        }
        bw.write(result+"");
        bw.flush();
    }

}



