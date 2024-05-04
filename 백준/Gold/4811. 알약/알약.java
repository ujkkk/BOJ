import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static long dp [][];
    public static long count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            count = 0;
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;
            dp = new long[N+1][N+1];

            DFS(N, 0);
            bw.write(dp[N][0]+"\n");

        }
        bw.flush();
    }

    /**
     *
     * @param W : 완전한 알약 개수
     * @param H : 반개 개수
     */
    public static long DFS(int W, int H){
        if(W == 0)
            return 1;
        else{
            if(dp[W][H] != 0)
                return dp[W][H];

            if(H == 0){
                dp[W][H] = DFS(W-1, 1);
            }
            else{
                dp[W][H] = DFS(W-1, H+1) + DFS(W, H-1);
            }
        }
        return dp[W][H];
    }
}

