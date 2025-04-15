import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long [] sum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            sum[i] = (sum[i-1] + Integer.parseInt(st.nextToken()));
        }

        int [] mod = new int[M];
        for(int i=1; i<=N; i++){
            mod[(int)(sum[i]%M)]++;
        }

        long count = 0;
        for(int i=0; i<mod.length; i++){
            long n = mod[i];
            // 1일 때를 생각 못함
            if(n <= 1)
                continue;
            count += (n*(n-1))/2;
        }

        count += mod[0];
        System.out.println(count);
    }
}
