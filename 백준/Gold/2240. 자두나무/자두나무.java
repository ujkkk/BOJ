import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int A[][] = new int[2][T+1];
        int dp[][][] = new int [2][T+1][W+1];

        for(int i=1; i<=T; i++){
            int n = Integer.parseInt(br.readLine());
            A[n-1][i] = 1;
        }
        dp[0][1][0] = A[0][1];
        dp[1][1][1] = dp[0][1][0] + A[1][1];
        for(int i=2; i<= T; i++){
            // 이동 안했을 때 - 제자리에서 사과가 있으면 더하기
            dp[0][i][0] = dp[0][i-1][0] + A[0][i];
            dp[1][i][0] = dp[1][i-1][0] + A[1][i];
            for(int j =1; j<=W; j++){
                if(j >= i)
                    continue;
                // dp[i][j]는 i시간에 j번 이동해서 얻은 자두의 수
                // 가만히 있었을 때, 이동 해서 왔을 때 중 큰 값 구하기
                dp[0][i][j] = Math.max(dp[0][i-1][j], dp[1][i-1][j-1]) + A[0][i];

                dp[1][i][j] = Math.max(dp[1][i-1][j], dp[0][i-1][j-1]) + A[1][i];
            }
        }
        int max = 0;
        for(int n : dp[0][T])
            max = Math.max(max, n);

        for(int n : dp[1][T])
            max = Math.max(max, n);
        System.out.println(max);


    }








}

