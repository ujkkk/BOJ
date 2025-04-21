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
    private static List<Integer>[] graph;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(w);
            graph[w].add(v);
        }

        for(int i=1; i<=N; i++){
            boolean[] check = new boolean[N + 1];
            check[i]  = true;
            if(is5Depth(i, 1, check)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean is5Depth(int n, int depth, boolean[] check){
        if(depth == 5){
            return true;
        }

        for(int next : graph[n]){
            if(check[next]) continue;

            check[next] = true;
            if(is5Depth(next, depth+1, check)){
                return true;
            }
            check[next] = false;
        }
        return false;
    }



}
