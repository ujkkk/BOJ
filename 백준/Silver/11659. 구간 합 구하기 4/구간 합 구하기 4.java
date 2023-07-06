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

        // 구간 합 배열 선언
        long [] S = new long[N+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        S[0] = 0;

        for(int i= 1; i<N+1; i++){
            // 구간 합 구하기
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int p=0; p<M; p++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(S[j] - S[i-1]);
        }

    }
}