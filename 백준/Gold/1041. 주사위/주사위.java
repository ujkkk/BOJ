import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        long dice [] = new long[7];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<7; i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if(N==1){
            long sum = 0;
            Arrays.sort(dice);
            for(int i=1; i<=5; i++){
                sum += dice[i];
            }
            System.out.println(sum);
            return;
        }
        //3개 맞닿은 것중 가장 작은 것 찾기
        long [] minDices = new long[3];
        minDices[0] = Math.min(dice[1], dice[6]);
        minDices[1] = Math.min(dice[3], dice[4]);
        minDices[2] = Math.min(dice[2], dice[5]);

        // 오름차순 정렬
        Arrays.sort(minDices);
        long min_3 = Arrays.stream(minDices).sum();
        long min_2 = minDices[0] + minDices[1];
        long min_1 = minDices[0];

        long count2 =((4*(2*N-3)));
        long count3 = 4;
        long count1 = ((N-1)*(N-2)*4)+(N-2)*(N-2);
        long n = count3*(min_3) + count2*min_2 +
                count1*min_1;
        bw.write(n+"\n");

        bw.flush();

        bw.close();
        br.close();

    }
}