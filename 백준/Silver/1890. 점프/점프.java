import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main
{

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long [][] map = new long[N][N];
        long [][] dp = new long[N][N];
        dp[0][0] = 1L;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == N-1 && j== N-1){
                    break;
                }
                int length = (int)map[i][j];
                if(i+length < N)
                    dp[i+length][j] += dp[i][j];
                if(j+length <N)
                    dp[i][j+length] += dp[i][j];
            }
        }
        bw.write(dp[N-1][N-1]+"\n");

        bw.flush();

        bw.close();
        br.close();

    }

}

