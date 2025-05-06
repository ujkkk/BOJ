import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static final int RED = 1;
    static final int BLUE = -1;
    public static int N, M, K, X;
    public static List<Integer>[] graph;
    public static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> maxVisited = new ArrayList<>();
    public static int max = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

       int T = Integer.parseInt(br.readLine());

       for(int t=0; t<T; t++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int V = Integer.parseInt(st.nextToken());
           int E = Integer.parseInt(st.nextToken());

          graph = new ArrayList[V+1];
           for(int i=0; i<=V; i++){
               graph[i] = new ArrayList<>();
           }
           int start = 0;
           for(int i=0; i<E; i++){
               st = new StringTokenizer(br.readLine());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());

               graph[a].add(b);
               graph[b].add(a);

           }

           int [] check = new int[V+1];
           int i;
           for(i=1; i<=V; i++){
               if(check[i] == 0){
                    if(!bfs(i, check)){
                        break;
                    }
               }
              
           }

           if(i == V+1){
               System.out.println("YES");

           }
           else{
               System.out.println("NO");

           }

       }

    }


    private static boolean bfs(int start, int [] check){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        check[start] = RED;

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int next : graph[cur]){
                if(check[next] == check[cur]){
                    return false;
                }
                if(check[next] == 0){
                    check[next] = check[cur] == RED? BLUE : RED;
                    que.add(next);
                }
            }
        }
        return true;
    }

}
