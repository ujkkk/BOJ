import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static ArrayList<Integer> [] tree;
    public static int [] depth;
    public static int N, S,D;
    public static int count = 0;

    public void run () throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());   // 노드의 개수
         S = Integer.parseInt(st.nextToken());   // 케니소프트의 위치
         D = Integer.parseInt(st.nextToken());   // 힘

        tree = new ArrayList[N+1];
        for(int i=0; i<tree.length; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0 ;i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        if(N == 1){
            System.out.println(0);
        }
        // depth 배열만들기
        depth = new int[N+1];
        getDepth(S, new boolean[N+1]);
        System.out.println(getCount(S, 0, new boolean[N+1])-1);
    }

    public int getCount(int n, int count, boolean [] isVisited){
        isVisited[n] = true;
        if(depth[n] == D){
            // 돌아가기
            return count + 1;
        }
        for(int next: tree[n]){
            if(isVisited[next]){
                continue;
            }
            // 자식 depth중 제일 큰 것을 가기
            if(depth[next] >= D){
                count = getCount(next, count +1, isVisited);
            }
        }
        return count + 1;
    }

    public int getDepth(int n, boolean [] isVisited){
        isVisited[n] = true;

        // 리프 노드
        if(n != S  && tree[n].size() == 1){
            return (depth[n] = 0) + 1;
        }

        for(int next: tree[n]){
            if(isVisited[next]){
                continue;
            }
            // 자식 depth중 제일 큰 것을 지정
            depth[n] = Math.max(depth[n], getDepth(next, isVisited));
        }

        return depth[n] + 1;
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}

