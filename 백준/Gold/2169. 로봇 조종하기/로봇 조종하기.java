import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[N][M];
        // 1층 초기화
        dp[0][0] = map[0][0];
        for(int i=1; i<M; i++){
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        for(int i=1; i<N; i++){
            // 위에꺼 밑으로 그대로 전달
            for(int j=0; j<M; j++){
                dp[i][j] = dp[i-1][j] + map[i][j];
            }

            // -> 방향으로 전진할 때 갱신
            int [] leftToRight = new int[M];
            leftToRight[0] = dp[i][0];
            for(int j=1; j<M; j++){
                // 여기서 멈추거나, 여기까지 전진해오거나
                leftToRight[j] = Math.max(dp[i][j], leftToRight[j-1] + map[i][j]);
            }

            // <- 방향으로 전진할 때 갱신
            int [] rightToLeft = new int[M];
            rightToLeft[M-1] = dp[i][M-1];
            for(int j=M-2; j>=0; j--){
                // 여기서 멈추거나, 여기까지 전진해오거나
                rightToLeft[j] = Math.max(dp[i][j], rightToLeft[j+1] + map[i][j]);
            }

            for(int j=0; j<M; j++){
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }

}

