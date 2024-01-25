import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(getPactorial(N)/(getPactorial(K)*getPactorial(N-K))+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

    public static int getPactorial(int n){
        int sum =1;
        for(int i=n; i>1; i--){
            sum *= i;
        }
        return sum;
    }
}