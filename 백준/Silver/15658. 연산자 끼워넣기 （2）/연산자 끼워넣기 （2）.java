import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int [] A;

    static int min = Integer.MAX_VALUE - 101;
    static int max = -Integer.MAX_VALUE + 101;

    public static void main(String[] args) throws IOException {

        // 수의 개수
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int [] counts = new int[4];
        for(int i=0; i<4; i++){
            counts[i] = Integer.parseInt(st.nextToken());
        }

        getMaxMin(counts, 0, A[0]);

        System.out.println(max +"");
        System.out.println(min + "");
    }

    private static void getMaxMin(int [] counts, int depth, int ans){
        if(depth == N-1){
            min = Math.min(min, ans);
            max = Math.max(max, ans);
            return;
        }

        for(int i=0; i<4; i++) {
            if (counts[i] <= 0)
                continue;

            counts[i]--;
            if (i == 0) {   // 덧셈
                getMaxMin(counts, depth+1, ans + A[depth+1]);
            }
            else if (i == 1) {  // 뺄셈
                getMaxMin(counts, depth+1, ans - A[depth+1]);
            }
            else if (i == 2) {  // 곱셈
                getMaxMin(counts, depth+1, ans * A[depth+1]);
            }
            else if (i == 3) {  // 나눗셈
                getMaxMin(counts, depth+1, ans / A[depth+1]);
            }
            counts[i]++;
        }
    }

}
