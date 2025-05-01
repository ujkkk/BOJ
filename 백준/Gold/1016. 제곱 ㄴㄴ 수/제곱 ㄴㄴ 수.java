import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean A [] = new boolean[(int)(max-min+2)];
        Arrays.fill(A, true);

        // 나누어 떨어지는 수 찾기
        int cnt = 0;
        for(long n=2; n<=Math.sqrt(max); n++){
            long start = (long) Math.ceil((min)*1.0/(n*n));

            // j는 곱하는 값
            for(long j=start; ; j++){
                long cur = j*(n*n);
                if(cur > max) break;
                if(!A[(int)(cur-min)]) continue;

                if(cur < min) continue;
                A[(int)(cur-min)] = false;
                cnt++;
            }
        }

        System.out.println(max-min +1- cnt);
    }
}