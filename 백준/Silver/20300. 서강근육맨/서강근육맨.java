import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main
{

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long w [] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            w[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(w);
        long M = Long.MIN_VALUE;
        // 짝수면 앞, 뒤에서 하나씩
        if(N%2 == 0){
            for(int i=0; i<N/2; i++){
                M = Math.max(M, w[i] + w[N-1-i]);
            }
            // 홀수면 가장 큰 것은 제일 나중에
        } else{
            for(int i=0; i<N/2; i++){
                M = Math.max(M, w[i] + w[N-2-i]);
            }
            M = Math.max(w[N-1], M);
        }
        bw.write(M+"\n");

        bw.flush();

        bw.close();
        br.close();

    }

}

