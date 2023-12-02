import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long count [][] = new long[101][10];

        for(int i=1; i<=9; i++){
            count[1][i] = 1;
        }
        for(int i=2; i<=N; i++){
            // 끝의 자리가 1~8인 숫자의 개수
            for(int j=1; j<=8; j++){
                count[i][j] = count[i-1][j-1] + count[i-1][j+1];
                count[i][j] %=1000000000;
            }
            // 끝의 자리가 0이 숫자의 개수
            count[i][0] = count[i-1][1];
            count[i][0] %=1000000000;
            // 끝의 자리가 9이 숫자의 개수
            count[i][9] = count[i-1][8];
            count[i][9] %=1000000000;
        }
        long sum = 0;
        for(long digit_count : count[N]){
            sum += digit_count;
            sum %=1000000000;
        }
        bw.write(sum +"\n");
        bw.flush();
    }
}
