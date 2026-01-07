import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static ArrayList<Integer>[] parent;
    static int [] degree;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = new ArrayList<>();
        }
        degree = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parent[a].add(b);
            degree[b]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                que.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            int cur = que.poll();
            sb.append(cur).append(" ");

            for(int next : parent[cur]){
                if(--degree[next] == 0){
                    que.add(next);
                }
            }
        }

        System.out.println(sb);
    }

}
