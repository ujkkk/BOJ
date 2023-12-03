import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 적어도 C명
        int N = Integer.parseInt(st.nextToken()); // 홍보할 수 있는 도시의 개수

        // 사람 유치 수에 따른 가장 최소 비용
        long dp[] = new long[C+101];
        // 초기화
        for(int i=1; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0L;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for(int j=people; j<dp.length; j++){
                dp[j] = Math.min(dp[j], cost + dp[j-people]);
            }
        }

        // min값 찾기
        long min = Long.MAX_VALUE;
        for(int i=C; i<dp.length; i++)
            min = Math.min(min, dp[i]);

        bw.write(min +"\n");
        bw.flush();
    }

}
