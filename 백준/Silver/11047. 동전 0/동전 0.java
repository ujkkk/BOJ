import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] coins = new int[N];
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        while(K != 0){
            int i;
            for(i=0; i<N-1; i++){
                if(coins[i+1] > K)
                    break;
            }
            result += K/coins[i];
            K -= coins[i]*(K/coins[i]);
        }
        bw.write(result+"\n");

        bw.flush();
        bw.close();
        br.close();
    }


}
