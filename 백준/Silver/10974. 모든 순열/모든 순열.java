import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int count = 0;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine()); // 1~N

        int n = 1;
        for(int i=1; i<=N; i++){
            n *= i;
        }
        int [][] result = new int[n][N];

        getP(0, N, new int[N], new boolean[N+1], result);

        for(int [] cur : result){
           for(int i=0; i<cur.length; i++){
               bw.write(cur[i] + " ");
           }
           bw.write("\n");
        }
        bw.flush();

    }

    private static void getP(int depth, int size, int [] cur, boolean[] isSelect, int [][] result){
        if(depth == size ){
            for(int i=0; i<cur.length; i++){
                result[count][i] = cur[i];
            }
            count++;
            return;
        }

        for(int i=1; i<=size; i++){
            if(isSelect[i])
                continue;

            cur[depth] = i;
            isSelect[i] = true;
            getP(depth+1, size, cur, isSelect, result);

            isSelect[i] = false;
        }
    }
}
