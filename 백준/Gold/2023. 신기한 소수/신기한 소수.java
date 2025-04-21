import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> ans;


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=9; i++){
            dfs(i, 1, N);

        }
        Collections.sort(ans);
        for(int n : ans){
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n, int depth, int N){
        if(!isDecimal(n)) return;
        if(depth == N){
            ans.add(n);
            return;
        }

        for(int i=1; i<=9; i++){
            dfs(n*10 + i, depth+1, N);
        }
    }


    public static boolean isDecimal(int n){
        if(n==1) return false;
        for(int i=2; i*i <= n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
