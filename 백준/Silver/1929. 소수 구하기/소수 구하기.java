import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static void main(String [] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean [] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false; isPrime[1] = false;
        for(int i = 2; i<=Math.sqrt(N);i++){
            if(isPrime[i]){
                for(int j = i*i; j<=N; j+=i){
                    isPrime[j]= false;
                }
            }
        }

        for(int i =M; i<=N;i++){
            if(isPrime[i]){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
