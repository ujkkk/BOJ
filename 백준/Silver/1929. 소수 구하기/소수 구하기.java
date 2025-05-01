import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = 0;
    private static int N;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [] A = new boolean[M+1];
        Arrays.fill(A, true);

        // 소수구하기
        A[1] = false;
        for(int i=2; i*i <= M; i++){
            if(!A[i]) continue;

            for(int j=i+i; j<=M; j+= i){
                A[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=N; i<=M; i++){
            if(A[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
