import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static int dp[][];

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];
        bw.write(getSolution( N, K)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getSolution(int n, int k){
        if(dp[n][k] > 0)
            return dp[n][k];

        if( n== k || k==0)
            return dp[n][k] = 1;

        return dp[n][k] = (getSolution(n-1, k-1) + getSolution(n-1, k)) % 10_007;
    }


}