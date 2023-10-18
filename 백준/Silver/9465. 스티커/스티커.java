import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T>0) {
            T--;
            int N = Integer.parseInt(br.readLine());
            int [][] nums = new int[2][N];
            int [][] dp = new int[2][N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            //nums input
            for(int i=0; i<N; i++) {
                nums[0][i] = Integer.parseInt(st1.nextToken());
                nums[1][i] = Integer.parseInt(st2.nextToken());
            }

            /* solution */
            for(int i=0; i<N; i++) {
                if(i==0) {
                    dp[0][0] = nums[0][0];
                    dp[1][0] = nums[1][0];
                    continue;
                }

                int [] dx = new int[] {-2,-1};
                for(int j=0; j<dx.length; j++) {
                    int x = i +dx[j];
                    int y = 1;
                    if(x>=0 && y>=0) {
                        // 0행
                        dp[0][i] = Math.max(dp[0][i], nums[0][i]+dp[1][x]);
                        // 1행
                        dp[1][i] = Math.max(dp[1][i], nums[1][i]+ dp[0][x]);
                    }
                }
            }

            //max값 찾기
            int max = 0;
            for(int i=N-2; i<N; i++) {
                if(i <0) continue;
                int num = Math.max(dp[0][i], dp[1][i]);
                max = Math.max(max, num);
            }
            bw.write(Integer.toString(max)+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
