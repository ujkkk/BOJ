import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] cost = new int[N+1];
        int [] memory = new int[N+1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        // [cost][N] : N 개까지 탐색했을 때 cost 비용으로 끌 수 있는 최대 메모리
        int [][] dp = new int[100*N+101][N+1];

        for(int c =0; c< dp.length; c++){
            for(int i=1; i<=N; i++){
                if(c-cost[i] < 0){
                    dp[c][i] = dp[c][i-1];
                }
                else{
                    dp[c][i] = Math.max(dp[c][i-1], dp[c-cost[i]][i-1] + memory[i]);
                }

                if(dp[c][i] >= M){
                    System.out.println(c+"");
                    return;
                }
            }
        }

    }


}

