
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int [][] dp = new int[41][2];

    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        fibonacci(40);

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }


    static void fibonacci(int n){
        cnt++;
        if(n ==0){
            dp[n][0] = 1;
        }
        else if(n==1){
            dp[n][1] = 1;
        }
        else{
            if(dp[n-1][0] == 0){
                fibonacci(n-1);
            }
            if(dp[n-2][0] == 0){
                fibonacci(n-2);
            }

            dp[n][0] = dp[n-1][0] + dp[n-2][0];
            dp[n][1] = dp[n-1][1] + dp[n-2][1];
        }
    }

}