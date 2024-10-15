import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) throws IOException {
        String [] op = br.readLine().split(" ");
        int n = Integer.parseInt(op[0]);
        int m = Integer.parseInt(op[1]);

        int map [][] = new int[n][m];
        int [][] rows = new int[n][m];
        int [][] cols = new int[n][m];
        int [][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            String [] str = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1){
                    rows[i][j] = 1;
                    cols[i][j] = 1;
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                if(map[i][j] == 1){
                    rows[i][j] = rows[i][j-1] + 1;
                }

            }
        }

        for(int j=0; j<m; j++){
            for(int i=1; i<n; i++){
                if(map[i][j] == 1){
                    cols[i][j] = cols[i-1][j] + 1;
                }
            }
        }

        int size = Math.min(n, m);

        for(int p=1; p<size; p++){
            // 행 검사(세로)
            for(int i=1; i<=p; i++){
                int min = Math.min(rows[i][p], cols[i][p]);
                if(dp[i-1][p-1] >= (min-1)*(min-1)){
                    dp[i][p] = min * min;
                }
                else{
                    int a = (int)Math.sqrt(dp[i-1][p-1]);
                    if(a == 0){
                        continue;
                    }
                    dp[i][p] = (a+1)*(a+1);
                }
            }
            // 열 검사(가로)
            for(int j=1; j<=p; j++){
                int min = Math.min(rows[p][j], cols[p][j]);
                if(dp[p-1][j-1] >= (min-1)*(min-1)){
                    dp[p][j] = min * min;
                }
                else{
                    int a = (int)Math.sqrt(dp[p-1][j-1]);
                    if(a == 0){
                        continue;
                    }
                    dp[p][j] = (a+1)*(a+1);
                }
            }
        }

        // 남은 줄 검사
        if(n >= m){
            for(int p=size; p<n; p++) {
                // 열 검사(가로)
                for (int j = 1; j < m; j++) {
                    int min = Math.min(rows[p][j], cols[p][j]);
                    if (dp[p - 1][j - 1] >= (min - 1) * (min - 1)) {
                        dp[p][j] = min * min;
                    } else {
                        int a = (int) Math.sqrt(dp[p-1][j-1]);
                        if(a == 0){
                            continue;
                        }
                        dp[p][j] = (a + 1) * (a + 1);
                    }
                }
            }
        }
        else{
            for(int p=size; p<m; p++) {
                // 행 검사(세로)
                for (int j = 1; j < n; j++) {
                    int min = Math.min(rows[j][p], cols[j][p]);
                    if (dp[j - 1][p - 1] >= (min - 1) * (min - 1)) {
                        dp[j][p] = min * min;

                    } else {
                        int a = (int) Math.sqrt(dp[j-1][p-1]);
                        if(a == 0){
                            continue;
                        }
                        dp[j][p] = (a + 1) * (a + 1);
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);
    }

}

