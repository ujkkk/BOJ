import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // k번째 지워진 수 출력하기
        boolean nums [] = new boolean[N+1];
        int p =2;
        int k =0;
        while(true){
            for(int i=p; i<=N; i=i+p){
                if(nums[i]) continue;
                // true이면 지워진 수
                k++;
                nums[i] = true;

                // k번째 지워진 수 찾음
                if(k==K){
                    System.out.println(i+"");
                    return;
                }
            }
            for(int j=p+1; j<=N; j++){
                if(!nums[j]){
                    p = j;
                    break;
                }
            }
        }

    }

}