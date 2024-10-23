import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static int [] dis;
    public static int n, m, t;
    public static int s, g, h;
    public static ArrayList<Load>[] tree;
    public static ArrayList<Integer> reachPoints;
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int p= 0; p<T; p++){
            init();

            // 다익스트라
            getReach();
            Collections.sort(reachPoints);

            for(int r : reachPoints){
                if(dis[r] % 2 == 1)
                    bw.write(r+" ");
            }
            bw.write("\n");
        }
        bw.flush();

    }

    private static void init() throws IOException {
        // init
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 교차로
        m = Integer.parseInt(st.nextToken());   // 도로의 개수
        t = Integer.parseInt(st.nextToken());   // 목적지 후보의 개수

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());   // 시작점
        g = Integer.parseInt(st.nextToken());   // 후보 간선
        h = Integer.parseInt(st.nextToken());   // 후보 간선

        dis = new int[n+1];
        Arrays.fill(dis, 100_000_000);

        tree = new ArrayList[n+1];
        for(int i=0; i<tree.length; i++){
            tree[i] = new ArrayList<Load>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(v == g && w == h || v == h && w== g){
                tree[v].add(new Load(w,  cost*2 -1));
                tree[w].add(new Load(v, cost*2 -1));
            }
            else{
                tree[v].add(new Load(w,  cost*2));
                tree[w].add(new Load(v, cost*2));
            }
        }
        reachPoints = new ArrayList<>();

        for(int i=0; i<t; i++){
            reachPoints.add(Integer.parseInt(br.readLine()));
        }
    }

    public static void getReach(){
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Load> que = new PriorityQueue<>();

        boolean [] check = new boolean[n+1];

        que.add(new Load(s, 0));
        dis[s] = 0;

        while(!que.isEmpty()){
            Load cur = que.poll();

            if(check[cur.v]){
                continue;
            }
            check[cur.v] = true;

            for(Load next : tree[cur.v]){
                if(!check[next.v] &&  dis[next.v] > dis[cur.v] + next.cost){
                    dis[next.v] = dis[cur.v] + next.cost;

                    que.add(new Load(next.v, dis[next.v]));
                }
            }
        }
    }

}

class Load implements Comparable<Load>{
    int v;
    int cost;

    public Load(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Load o){
        return this.cost - o.cost;
    }


}

