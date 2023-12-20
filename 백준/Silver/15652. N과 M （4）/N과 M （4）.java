import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int [] arr;
    public static boolean [] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int M;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N+1];
        dfs(0,0);
        System.out.println(sb);


    }

    // 중복 허용, 다음수는 같거나 높아야 한다.
    public static void dfs(int n, int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1; i<=N; i++){
            if(i>= n){
                // 깊이에 따라 변경을 해주니 넣고 빼줄 필요가 없다.
                arr[depth] = i;
                dfs(i,depth+1);
            }
        }

    }
}
