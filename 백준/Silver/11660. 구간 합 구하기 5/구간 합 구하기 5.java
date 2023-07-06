import javax.sql.rowset.serial.SQLInputImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int [][] nums = new int[N+1][N+1];
        long [][] S = new long[N+1][N+1];

        for(int i=1 ; i< N+1; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1; j< N+1; j++){
                nums[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=1; i< N+1; i++){
            S[1][i] = S[1][i-1] + nums[1][i];
            S[i][1] = S[i-1][1] + nums[i][1];
        }

        // 모든 구간 합 구하기
        for(int i=2; i< N+1; i++){
            for(int j=2; j< N+1; j++){
                S[i][j] = nums[i][j]+ S[i-1][j] + S[i][j-1] - S[i-1][j-1];
            }
        }

        int x1,x2,y1,y2;
        for(int i=0; i<M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            x1 = Integer.parseInt(stringTokenizer.nextToken());
            y1 = Integer.parseInt(stringTokenizer.nextToken());
            x2 = Integer.parseInt(stringTokenizer.nextToken());
            y2 = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1]
            + S[x1-1][y1-1]);
        }
    }
}