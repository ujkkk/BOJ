import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static final int MOD = 1_000_000_009;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static long dp [][] = new long[100_000+1][4];

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());       // 테케 개수

        solution();
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(getAnswer(n)+"\n");
        }
        bw.flush();
    }

    public static void solution(){
        dp[1][1] = dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for(int i=4; i<=100_000; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }
    }

    public static long getAnswer(int n){
        return (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;

    }

}


