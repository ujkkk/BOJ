
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1]; //  1에서 n을 만들기까지 최소 연산 수
        Arrays.fill(dp, 1_000_010);
        dp[N] = 0;

        // 1_000_000 (백만)
        for(int i=N; i>=1; i--) {
            dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
            if(i%2 == 0)
                dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
            if(i%3 == 0)
                dp[i/3] = Math.min(dp[i/3], dp[i] + 1);
        }
        System.out.println(dp[1]);
    }

}