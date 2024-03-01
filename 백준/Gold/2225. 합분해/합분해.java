import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // K개를 이용해서 N 만들기
        int [][] dp = new int[K+1][N+1];

        for(int i=0; i<=N; i++){
            dp[1][i] = 1;
        }
        for(int i=0; i<=K; i++){
            dp[i][0] = 1;
        }

        for(int i=2; i<=K; i++){
            for(int j=1; j<=N; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])% 1_000_000_000;
            }
        }

        System.out.println(dp[K][N]);


    }






}

