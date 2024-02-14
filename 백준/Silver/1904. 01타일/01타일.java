
import java.io.*;

/*
    문제를 작은 문제들로 나눠 풀 수 있음 -> dp 이용
 */
import java.util.*;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;


    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++){
            dp[i]= (dp[i-1]+dp[i-2])%15746;
        }

        bw.write(dp[N]+ "");
        bw.flush();
    }

}



