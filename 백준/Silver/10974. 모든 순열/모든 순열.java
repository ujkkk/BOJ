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


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine()); // 1~N

        int n = 1;
        for(int i=1; i<=N; i++){
            n *= i;
        }
        List<String> result = new ArrayList<>();

        getP(1, N, new int[N+1], new boolean[N+1], result);

        for(String str : result){
            bw.write(str+"\n");
        }
        bw.flush();

    }

    private static void getP(int depth, int size, int [] cur, boolean[] isSelect,  List<String> result){
        if(depth == size +1){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i < cur.length; i++){
                sb.append(cur[i]).append(" ");
            }
            result.add(sb.toString());
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
