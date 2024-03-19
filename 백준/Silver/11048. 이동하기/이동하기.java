
import java.io.*;
import java.util.*;


public class Main {

   public static void main(String[] args) throws Exception  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int [][] A = new int[N][M];
      int [][] dp = new int[N][M];
      
      
      for(int i=0; i<N; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0; j <M; j++) {
            A[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      dp[0][0] = A[0][0];
      for(int i=1; i<M; i++) {
         dp[0][i] = dp[0][i-1] + A[0][i];
      }
      
      for(int r=1; r<N; r++) {
         for(int c =0; c<M; c++) {
            dp[r][c] = dp[r-1][c];
            if(r-1 >=0 && c-1 >=0) {
               dp[r][c] = Math.max(dp[r][c], dp[r-1][c-1]);
            }
            
            if(c-1 >=0) {
               dp[r][c] = Math.max(dp[r][c], dp[r][c-1]);
            }
            
            dp[r][c] += A[r][c];
         }
      }
      System.out.println(dp[N-1][M-1]);
   }

      
}

