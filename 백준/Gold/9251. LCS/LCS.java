import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char [] A = br.readLine().toCharArray();
        char [] B = br.readLine().toCharArray();
        int dp[][] = new int[A.length+1][B.length+1];

        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        bw.write(dp[A.length][B.length]+"\n");
        bw.flush();
    }

}
