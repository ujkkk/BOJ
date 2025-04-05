import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 모든 트리가 이어져 있는지 확인
        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0; i<N; i++){
            boolean [] check = new boolean[N];
            check[i] = true;

            if(dfs(N, 1, i, check)){
                System.out.println(1+"\n");
                return;
            }
        }
        System.out.println(0+"\n");
    }

    private static boolean dfs(int N, int depth, int n, boolean [] check){
        if(depth >= 5){
            return true;
        }

        for(int next : graph[n]){
            if(check[next])
                continue;

            check[n] = true;
            if(dfs(N, depth+1, next, check)){
                return true;
            }
            check[n] = false;
        }
        return false;
    }
}