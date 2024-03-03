import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double dp[] = new double[N+1];
        double A[] = new double[N+1];

        for(int i=0; i<N; i++){
            A[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = A[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(A[i], dp[i-1]*A[i]);
        }

        double ans = 0.0;
        for(double n : dp)
            ans = Math.max(ans, n);
        System.out.println(String.format("%.3f", ans));

        bw.flush();

    }








}

