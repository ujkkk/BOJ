import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int [] w;
    public static int [] v;

    public void run () throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] dp = new int[N+1][K+1];
        w = new int[N+1];
        v= new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken()); // 무게
            v[i] = Integer.parseInt(st.nextToken()); // 가치
        }
        // 물건의 수만큼 반복
        for(int i=1; i<=N; i++){
            // 최대 무게만큼 반복
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                // 무게에서 자신의 무게를 뺏을 때 남는 무게가 존재하면,
                if(j - w[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}

