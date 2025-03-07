import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int run(int N, int [][] friends){
        boolean [] v = new boolean[N];

        int [] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        nCr(0, N, v, ans, friends);


        return ans[0];
    }

    private void nCr(int depth, int n, boolean[] v,  int [] result,  int [][] friends){
        if(depth == n){
            // 계산
            result[0] = Math.min(result[0], diff(v, friends));
            // min 값 갱신
            return;
        }

        v[depth] = true;
        // 뽑았을 때
        nCr(depth+1, n, v, result, friends);
        v[depth] = false;
        // 뽑지 않았을 때
        nCr(depth+1, n, v, result, friends);
    }

    private int diff(boolean [] v,  int [][] friends){
        int size = v.length;
        int start = 0;
        int link = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i == j) continue;
                if(v[i] && v[j]){
                    start+=friends[i][j];
                }
                else if(!v[i] && !v[j]){
                    link+= friends[i][j];
                }
            }
        }
        return Math.abs(start - link);
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [][] friends = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                friends[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(new Main().run(N, friends));
    }


}

