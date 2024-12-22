import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int [][] cost = {
        {1, 2, 2, 2, 2},
        {0, 1, 3, 4, 3},
        {0, 3, 1, 3, 4},
        {0, 4, 3, 1, 3},
        {0, 3, 4, 3, 1}
    };
    public static void main(String[] args) throws IOException {

        String [] str = br.readLine().split(" ");
        int n = str.length;
        int [] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        // dp[순서][왼쪽][오른쪽] = 최소비용
        int [][][] dp = new int[n][5][5];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<5; j++){
                for(int k = 0; k<5; k++){
                    dp[i][j][k] = 2147483643;
                }
            }
        }

        dp[0][0][0] = 0;

        for(int i=0; i<n -1; i++){
            int next = nums[i];

            for(int left=0; left<5; left++){
                for(int right=0; right<5; right++){
                    // 왼쪽 발을 이동할 시 최솟값
                    if(next != right)
                        dp[i+1][next][right] = Math.min(dp[i+1][next][right], dp[i][left][right] + cost[left][next]);

                    // 오른쪽 발을 이동할 시 최솟값
                    if(next != left)
                        dp[i+1][left][next] = Math.min(dp[i+1][left][next], dp[i][left][right] + cost[right][next]);
                }
            }
        }

        int result = 2147483643;
        for(int j = 0; j<5; j++){
            for(int k = 0; k<5; k++){
                result = Math.min(dp[n-1][j][k], result);
            }
        }

        bw.write(result+"");
        bw.flush();
    }

}

